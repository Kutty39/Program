package com.blbz.stockaccountnanagement.service;

public interface StockAccount {
    void StockAccount(String filename,double amount);
    boolean openJSON(String filename);
    double valueof();
    void buy(double amount, String symbol);
    void sell(int amount,String symbol);
    void save(String filename);
    void printReport();

}
