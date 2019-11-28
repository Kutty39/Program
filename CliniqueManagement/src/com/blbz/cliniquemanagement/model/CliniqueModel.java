package com.blbz.cliniquemanagement.model;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class CliniqueModel {
    private static JSONObject doctors = new JSONObject();
    private static JSONObject patients = new JSONObject();
    private static JSONObject appointments = new JSONObject();
    private static JSONArray details = new JSONArray();

    private static JSONArray dname = new JSONArray();
    private static JSONArray did = new JSONArray();
    private static JSONArray dspc = new JSONArray();
    private static JSONArray davl = new JSONArray();

    private static JSONArray pname = new JSONArray();
    private static JSONArray ptage = new JSONArray();
    private static JSONArray pid = new JSONArray();
    private static JSONArray pphn = new JSONArray();


    private static JSONObject base = new JSONObject();
    private static JSONObject tmpjsonobj = new JSONObject();
    public static JSONParser jsonreader = new JSONParser();

    public static String getFilename() {
        return "jsonfiles/database.json";
    }

    public static JSONObject getDoctor() {
        return doctors;
    }

    public static void setDoctor(JSONObject doctor) {
        CliniqueModel.doctors = doctor;
    }

    public static JSONObject getPatients() {
        return patients;
    }

    public static void setPatients(JSONObject patients) {
        CliniqueModel.patients = patients;
    }

    public static JSONObject getAppointmentArray() {
        return appointments;
    }

    public static void setAppointments(JSONObject appointments) {
        CliniqueModel.appointments = appointments;
    }

    public static JSONArray getDetails() {
        return details;
    }

    public static void setDetails(JSONArray details) {
        CliniqueModel.details = details;
    }

    public static JSONObject getBase() {
        return base;
    }

    public static void setBase(JSONObject base) {
        CliniqueModel.base = base;
    }

    public static JSONObject getTmpjsonobj() {
        return tmpjsonobj;
    }

    public static void setTmpjsonobj(String key, String value) {
        CliniqueModel.tmpjsonobj.put(key, value);
    }

    public static JSONArray getDname() {
        return dname;
    }

    public static void setDname(JSONArray dname) {
        CliniqueModel.dname = dname;
    }

    public static JSONArray getDid() {
        return did;
    }

    public static void setDid(JSONArray did) {
        CliniqueModel.did = did;
    }

    public static JSONArray getDspc() {
        return dspc;
    }

    public static void setDspc(JSONArray dspc) {
        CliniqueModel.dspc = dspc;
    }

    public static JSONArray getDavl() {
        return davl;
    }

    public static void setDavl(JSONArray davl) {
        CliniqueModel.davl = davl;
    }

    public static JSONArray getPname() {
        return pname;
    }

    public static void setPname(JSONArray pname) {
        CliniqueModel.pname = pname;
    }

    public static JSONArray getPtage() {
        return ptage;
    }

    public static void setPtage(JSONArray page) {
        CliniqueModel.ptage = page;
    }

    public static JSONArray getPid() {
        return pid;
    }

    public static void setPid(JSONArray pid) {
        CliniqueModel.pid = pid;
    }

    public static JSONArray getPphn() {
        return pphn;
    }

    public static void setPphn(JSONArray pphn) {
        CliniqueModel.pphn = pphn;
    }
}
