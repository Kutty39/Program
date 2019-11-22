package com.blbz.inventorymanagement.model;

/*
Created by : Mr. Tamilselvan S
Created on : 20/11/2019
Purpose of Creating : Initiating all the variable which used mainly everywhere
 */

import org.json.simple.JSONObject;

import java.io.*;

public class Inventory {
    private static JSONObject inv = new JSONObject();//this is for storing base object
    private static File fl;//to get the file
    private static FileReader fr;//to read the file
    private static boolean continueflag;//this is to check the continuation of the loops in main menu.

    public static File getFl() {
        Inventory.fl = new File("fils/InventeryJSON.json");
        return fl;
    }//get the files

    public static void setFl(String path) {
        Inventory.fl = new File(path);
    }//set the file values

    public static FileReader getFr() throws FileNotFoundException {//get the file reader
        fr = new FileReader(getFl());
        return fr;
    }


    public static JSONObject getInv() {//to get base jsonobject
        return inv;
    }

    public static void setInv(JSONObject inv) {// assign the value to base json object
        Inventory.inv = inv;
    }

    public static boolean isContinueflag() {
        return continueflag;
    }

    public static void setContinueflag(boolean continueflag) {
        Inventory.continueflag = continueflag;
    }
}
