package com.blbz.addressbook.model;

/*
Created by : Tamilselvan S.
Created on : 22/11/2019.
Purpose : created this is for data encapsulation.
 */
import java.util.HashMap;


public class AddressBookModel {
    private static boolean continueflag;
    private static String filename;
    private static HashMap<String, HashMap<String, String>> persion;

    //get the person detail. it will become null at the initial stage
    public static HashMap<String, HashMap<String, String>> getPersion() {
        if (AddressBookModel.persion == null) {
            AddressBookModel.persion = new HashMap<>();
        }
        return AddressBookModel.persion;
    }

    //set person detail
    public static void setPersion(HashMap detail) {
        AddressBookModel.persion = detail;
    }

    //will give the continue flag to the mail loop
    public static boolean isContinueflag() {
        return continueflag;
    }

    //setting the continue flag
    public static void setContinueflag(boolean continueflag) {
        AddressBookModel.continueflag = continueflag;
    }

    //get the file name in which you are currently working
    public static String getFilename() {
        return filename;
    }

    //set the file name, to swith between files
    public static void setFilename(String filename) {
        AddressBookModel.filename = "Jsonfolder/" + filename;
    }

}
