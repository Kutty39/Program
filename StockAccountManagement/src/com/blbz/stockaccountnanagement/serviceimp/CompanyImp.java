package com.blbz.stockaccountnanagement.serviceimp;

import com.blbz.stockaccountnanagement.repository.CompanyFileHandler;
import com.blbz.stockaccountnanagement.service.Company;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import static com.blbz.stockaccountnanagement.model.StockModel.*;

public class CompanyImp extends CompanyFileHandler implements Company {

    public CompanyImp() {
        readCompanyJSON();
    }

    @Override
    public void addStock(String companyname, String stocksymbol, double nos, double priceperstock) {
        JSONArray detail = new JSONArray();
        JSONObject obj = getBaseobjcompany();
        detail.add(companyname);
        detail.add(nos);
        detail.add(priceperstock);
        detail.add(priceperstock * nos);
        obj.put(stocksymbol, detail);
        setBaseobjcompany(obj);
        setFiledited(true);
    }

    @Override
    public boolean validateSym(String sym) {
        return getBaseobjcompany().get(sym) == null;
    }

    @Override
    public boolean deleteStock(String sym) {
        if (getBaseobjcompany().get(sym) != null) {
            getBaseobjcompany().remove(sym);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void save() {
        writeCompanyJSON();
        setFiledited(false);
    }

    @Override
    public String getdetails(String sym) {
        return getBaseobjcompany().get(sym).toString();
    }

    @Override
    public void displayAllDetails() {
        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.println("Stock Symbol \t|\tCompany Name \t|\tNo.of Share  \t|\tStock Price  \t|\tTotal Price");
        System.out.println("--------------------------------------------------------------------------------------------");
        getBaseobjcompany().forEach((k, v) -> {
            int ln = String.valueOf(k).length();
            System.out.print(k + (" ".repeat(13 - ln)) + "\t|\t");
            JSONArray ary = (JSONArray) v;
            ary.forEach(e -> {
                int ln1 = String.valueOf(e).length();
                System.out.print(e + (" ".repeat(13 - ln1)) + "\t|\t");
            });
            System.out.println();
        });
        System.out.println("--------------------------------------------------------------------------------------------");
    }
}
