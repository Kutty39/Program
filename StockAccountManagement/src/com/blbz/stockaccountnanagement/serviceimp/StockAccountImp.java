package com.blbz.stockaccountnanagement.serviceimp;

import com.blbz.stockaccountnanagement.repository.StockAccountFileHandler;
import com.blbz.stockaccountnanagement.service.StockAccount;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.blbz.stockaccountnanagement.model.StockModel.*;

public class StockAccountImp implements StockAccount {
    StockAccountFileHandler saf;

    public StockAccountImp() {
        saf = new StockAccountFileHandler();
    }

    public void stockAccount(String filename, double amount) {
        saf.createJSON(filename, amount);
    }

    public boolean openJSON(String filename) {
        return saf.openJSON(filename);
    }

    @Override
    public double valueof() {
        return (double) getBaseobjuser().get("Amount");
    }

    @Override
    public void buy(double amount, String symbol) {
        double d;
        //Doing calculation on company json file
        JSONArray symary = (JSONArray) getBaseobjcompany().get(symbol);
        double nos = amount / ((double) symary.get(2));//to find how many share we can buy
        double balamount = 0;
        if ((double) symary.get(1) == 0) {
            System.out.println("There is no share to buy");
        } else {
            if ((double) symary.get(1) < nos) {//checking whether the company has that much shares or not
                nos = (double) symary.get(1); //getting all the shares
                balamount = amount - (nos * (double) symary.get(2));//After buying the shares how much is our balance amount
                amount = ((double) symary.get(1) * (double) symary.get(2));//setting buying amount
                symary.remove(1);//to update no of shares we should remove that element from the array
                symary.add(1, 0);//adding the update no of share in the same position
                symary.remove(3);//removing amount
                symary.add(3, 0);//adding amount
                System.out.println("Company has less no of stock than you expect.\nSo we bough all the stock and we credited balance amount to your account");
            } else {
                d = (double) symary.get(1) - nos;//calculating balance the no of share
                //remove and adding no of share
                symary.remove(1);
                symary.add(1, d);
                //calculating final amount and performing remove and add
                d = (double) symary.get(3) - amount;
                symary.remove(3);
                symary.add(3, d);

                balamount = valueof() - amount;//user account balance
            }

            //file edited true it will use for saving the files
            setFiledited(true);

            //update holding part
            JSONArray trn = new JSONArray();
            DateTimeFormatter formater = DateTimeFormatter.ofPattern("dd-MM-yyyy 'at' hh:mm a");
            String date = LocalDateTime.now().format(formater);
            JSONObject hold = (JSONObject) getBaseobjuser().get("Holdings");
            JSONArray tmp;
            if (hold.get(symbol) == null) {
                //if the share is new we add directly
                trn.add(nos);
                trn.add(symary.get(2));
                trn.add(amount);
                trn.add(LocalDateTime.now().format(formater));
                trn.add(symary.get(0));
                hold.put(symbol, trn);
            } else {
                //if already we have that share, we need to update it
                tmp = (JSONArray) hold.get(symbol);
                d = (double) tmp.get(0) + nos;
                tmp.remove(0);
                tmp.add(0, d);
                d = ((double) tmp.get(1) + (double) symary.get(2)) / 2;
                tmp.remove(1);
                tmp.add(1, d);
                d = (double) tmp.get(2) + amount;
                tmp.remove(2);
                tmp.add(2, d);
                tmp.remove(3);
                tmp.add(3, date);
            }

            //updating user account balance
            getBaseobjuser().put("Amount", balamount);

            //Transaction part
            tmp = new JSONArray();
            tmp.add(symary.get(0));
            tmp.add(symbol);
            tmp.add(nos);
            tmp.add(symary.get(2));
            tmp.add(amount);
            tmp.add("Buy");
            tmp.add(date);

            JSONArray trans = (JSONArray) getBaseobjuser().get("transaction");
            trans.add(tmp);
            System.out.println(getBaseobjcompany().toString());
            System.out.println("--------------------------------------------------");
            System.out.println(getBaseobjuser().toString());
        }
    }

    @Override
    public void sell(double amount, String symbol) {
        double d;
        JSONArray tmpary;
        //Doing calculation on company json file
        JSONArray symary = (JSONArray) getBaseobjcompany().get(symbol);
        double nos = amount / ((double) symary.get(2));//to find how many share we can buy
        double balamount = 0;
        JSONObject hold = (JSONObject) getBaseobjuser().get("Holdings");

        tmpary = (JSONArray) hold.get(symbol);
        if (tmpary == null) {
            System.out.println("There is no share to sell");
        } else {
            if ((double) tmpary.get(0) < nos) {//checking whether you have that much shares or not
                nos = (double) tmpary.get(0); //getting all the shares
                balamount = amount - (nos * (double) symary.get(2));//After selling the shares how much is our balance amount
                amount = ((double) tmpary.get(0) * (double) symary.get(2));//setting selling amount
                System.out.println("you have less no of stock than you expect.\nSo we sold all the stock and we credited balance amount to your account");
            }

            //calculating balance the no of share
            d = (double) symary.get(1) + nos;
            //remove and adding no of share
            symary.remove(1);
            symary.add(1, d);
            //calculating final amount and performing remove and add
            d = (double) symary.get(3) + amount;
            symary.remove(3);
            symary.add(3, d);

            balamount = valueof() + amount;//user account balance

            //file edited true it will use for saving the files
            setFiledited(true);

            //update holding part
            JSONArray trn = new JSONArray();
            DateTimeFormatter formater = DateTimeFormatter.ofPattern("dd-MM-yyyy 'at' hh:mm a");
            String date = LocalDateTime.now().format(formater);

            //we need to update holdings
            tmpary = (JSONArray) hold.get(symbol);
            d = (double) tmpary.get(0) - nos;
            if (d == 0) {
                hold.remove(symbol);
            } else {
                tmpary.remove(0);
                tmpary.add(0, d);
                d = ((double) tmpary.get(1) + (double) symary.get(2)) / 2;
                tmpary.remove(1);
                tmpary.add(1, d);
                d = (double) tmpary.get(2) - amount;
                tmpary.remove(2);
                tmpary.add(2, d);
                tmpary.remove(3);
                tmpary.add(3, date);
                tmpary.remove(4);
                tmpary.add(4,symary.get(0));
            }

            //updating user account balance
            getBaseobjuser().put("Amount", balamount);

            //Transaction part
            tmpary = new JSONArray();
            tmpary.add(symary.get(0));
            tmpary.add(symbol);
            tmpary.add(nos);
            tmpary.add(symary.get(2));
            tmpary.add(amount);
            tmpary.add("Sell");
            tmpary.add(date);

            JSONArray trans = (JSONArray) getBaseobjuser().get("transaction");
            trans.add(tmpary);
            System.out.println(getBaseobjcompany().toString());
            System.out.println("--------------------------------------------------");
            System.out.println(getBaseobjuser().toString());
        }
    }

    @Override
    public void save() {
        saf.writeJSON();
        setFiledited(false);
    }

    @Override
    public boolean validateSym(String sym) {
        JSONObject hold = (JSONObject) getBaseobjuser().get("Holdings");
        return hold.get(sym) != null;
    }

    @Override
    public double validateAmt(String sym) {
        JSONArray cmary = (JSONArray) getBaseobjcompany().get(sym);
        JSONObject hold = (JSONObject) getBaseobjuser().get("Holdings");
        JSONArray ary = (JSONArray) hold.get(sym);
        if (ary != null) {
            return (double) ary.get(1) * (double) cmary.get(2);
        } else {
            return 0;
        }
    }

    @Override
    public void holdingReport() {
        JSONObject hold = (JSONObject) getBaseobjuser().get("Holdings");
        System.out.println("Symbol               \tNo.of Stock          \tStock price           \tTotal Amount        \tTransaction Date      \tCompany Name");
        hold.forEach((k,v)->{
            JSONArray v1= (JSONArray) v;
            String tmp= (String) k;
            System.out.print(tmp+(" ".repeat(22-tmp.length()))+"\t");
            v1.forEach(a->{
                String tmp1= String.valueOf(a);
                System.out.print(tmp1+(" ".repeat(22-tmp1.length()))+"\t");
            });
            System.out.println();
        });
    }

    @Override
    public void transactionReport() {
        JSONArray transaction = (JSONArray) getBaseobjuser().get("transaction");
        System.out.println("Company Name     \tSymbol           \tNo.of Stock      \tStock price        \tTotal Amount    \tAction            \tTransaction Date");
        transaction.forEach(v->{
            JSONArray v1= (JSONArray) v;
            v1.forEach(a->{
                String tmp1= String.valueOf(a);
                System.out.print(tmp1+(" ".repeat(Math.max(18 - tmp1.length(), 0)))+"\t");
            });
            System.out.println();
        });
    }

    @Override
    public void addingAmount(double inputDouble) {
        getBaseobjuser().put("Amount",valueof()+inputDouble);
        setFiledited(true);
    }
}
