package com.blbz.stockaccountnanagement.serviceimp;

import com.blbz.stockaccountnanagement.repository.StockAccountFileHandler;
import com.blbz.stockaccountnanagement.service.StockAccount;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.blbz.stockaccountnanagement.model.StockModel.*;

public class StockAccountImp implements StockAccount {
    StockAccountFileHandler saf;

    public StockAccountImp() {
        saf = new StockAccountFileHandler();
    }

    public void StockAccount(String filename, double amount) {
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
        JSONArray symary = (JSONArray) getBaseobjcompany().get(symbol);
        double nos = amount / ((double) symary.get(2));
        double balamount = 0;
        if ((double) symary.get(1) < nos) {
            symary.add(1, 0);
            nos = (double) symary.get(1);
            balamount = amount - (nos * (double) symary.get(2));
            amount = ((double) symary.get(1) * (double) symary.get(2));
            System.out.println("Company has less no of stock than you expect.\nSo we bough all the stock and we credited balance amount to your account");
        } else {
            symary.add(1, (double) symary.get(1) - nos);
            balamount = valueof() - amount;
        }
        setFiledited(true);

        //update holding part
        JSONArray trn = new JSONArray();
        DateTimeFormatter formater = DateTimeFormatter.ofPattern("dd-MM-yyyy 'at' hh:mm a");
        String date = formater.format(LocalDateTime.now());
        JSONObject hold = (JSONObject) getBaseobjuser().get("Holdings");
        JSONArray tmp = new JSONArray();
        if (hold.get(symbol) == null) {
            trn.add(nos);
            trn.add((double) symary.get(2));
            trn.add(amount);
            trn.add(LocalDateTime.now().format(formater));
            hold.put(symbol, trn);
        } else {
            tmp = (JSONArray) hold.get(symbol);
            tmp.add(0, (double) tmp.get(0) + nos);
            tmp.add(1, ((double) tmp.get(10) + (double) symary.get(2)) / 2);
            tmp.add(2, (double) tmp.get(10) + amount);
            tmp.add(3, date);
        }

        //Transaction part
        tmp = new JSONArray();
        tmp.add(symbol);
        tmp.add(nos);
        tmp.add(amount);
        tmp.add("Buy");
        tmp.add(date);

        JSONArray trans= (JSONArray) getBaseobjuser().get("transaction");
        trans.add(tmp);
        System.out.println(getBaseobjcompany().toString());
        System.out.println("--------------------------------------------------");
        System.out.println(getBaseobjuser().toString());
    }

    @Override
    public void sell(int amount, String symbol) {

    }

    @Override
    public void save(String filename) {

    }

    @Override
    public void printReport() {

    }
}
