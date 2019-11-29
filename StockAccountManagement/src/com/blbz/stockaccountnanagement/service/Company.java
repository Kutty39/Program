package com.blbz.stockaccountnanagement.service;

public interface Company {
    void addStock(String companyname,String stocksymbol,double nos,double priceperstock);
    boolean validateSym(String sym);
    boolean deleteStock(String sym);
    void save();
    String getdetails(String sym);
    void displayAllDetails();
}
