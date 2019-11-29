package com.blbz.stockaccountnanagement.model;

import org.json.simple.JSONObject;

public class StockModel {
    private static String filename;
    private static final String companyfilename="jsonfolder/company.json";
    private static JSONObject baseobjuser;
    private static JSONObject baseobjcompany;
    private static boolean filedited;

    public static String getFilename() {
        return filename;
    }

    public static  void setFilename(String filename) {
        StockModel.filename = filename;
    }

    public static JSONObject getBaseobjuser() {
        return baseobjuser;
    }

    public static void setBaseobjuser(JSONObject baseobjuser) {
        StockModel.baseobjuser = baseobjuser;
    }

    public static JSONObject getBaseobjcompany() {
        return baseobjcompany;
    }

    public static void setBaseobjcompany(JSONObject baseobjcompany) {
        StockModel.baseobjcompany = baseobjcompany;
    }

    public static String getCompanyfilename() {
        return companyfilename;
    }

    public static boolean isFiledited() {
        return filedited;
    }

    public static void setFiledited(boolean filedited) {
        StockModel.filedited = filedited;
    }
}
