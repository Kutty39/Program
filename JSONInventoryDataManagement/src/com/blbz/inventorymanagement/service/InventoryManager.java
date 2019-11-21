package com.blbz.inventorymanagement.service;

/*
Created by : Mr. Tamilselvan S
Created on : 20/11/2019
Purpose of Creating : Interface for the application which will have all the methods
 */

public interface InventoryManager {
    //Need this methode to add value in json
    void addItem(String item, String itemname, double weight, double priceperkg);
    double calculate(String item);
}
