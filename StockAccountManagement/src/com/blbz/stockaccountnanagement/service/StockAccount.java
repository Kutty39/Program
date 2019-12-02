package com.blbz.stockaccountnanagement.service;

public interface StockAccount {
    void stockAccount(String filename, double amount);
    boolean openJSON(String filename);
    double valueof();
    void buy(double amount, String symbol);
    void sell(double amount,String symbol);
    void save();
    boolean validateSym(String sym);
    double validateAmt(String sym);
    void holdingReport();
    void transactionReport();

    void addingAmount(double inputDouble);
}
