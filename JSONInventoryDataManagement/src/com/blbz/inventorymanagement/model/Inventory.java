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
    private static FileWriter fw;//file writer to write data in the files

    public static File getFl() {
        return fl;
    }//get the files

    public static void setFl(String path) {
        Inventory.fl = new File(path);
    }//set the file values

    public static FileWriter getFw() throws IOException {//will return the  file writer
        fw = new FileWriter(getFl());
        return fw;
    }

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
}
