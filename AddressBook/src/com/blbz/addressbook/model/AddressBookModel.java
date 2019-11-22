package com.blbz.addressbook.model;

import netscape.javascript.JSObject;

import java.util.HashMap;

public class AddressBookModel {
    private static boolean continueflag;
    private static String filename;
    private static  HashMap<String, HashMap<String, String>> persion;
    private JSObject baseobj;

    public JSObject getBaseobj() {
        return baseobj;
    }

    public void setBaseobj(JSObject baseobj) {
        this.baseobj = baseobj;
    }

    public static HashMap<String, HashMap<String, String>> getPersion() {
        if(AddressBookModel.persion==null){
            AddressBookModel.persion=new HashMap<>();
        }
        return AddressBookModel.persion;
    }

    public static void setPersion(HashMap detail) {
        AddressBookModel.persion=detail;
    }
    public static boolean isContinueflag() {
        return continueflag;
    }

    public static void setContinueflag(boolean continueflag) {
        AddressBookModel.continueflag = continueflag;
    }

    public static String getFilename() {
        return filename;
    }

    public static void setFilename(String filename) {
        AddressBookModel.filename = "Jsonfolder/"+filename;
    }
}
