package com.blbz.stockaccountnanagement.repository;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;

import static com.blbz.stockaccountnanagement.model.StockModel.*;

public class StockAccountFileHandler {
    //StockAccountModel sm;

    public StockAccountFileHandler() {
       // sm = new StockAccountModel();
    }

    public void createJSON(String filename, double amount) {
        File fl = new File("jsonfolder/" + filename + ".json");
        if (!fl.exists()) {
            try (FileWriter fw = new FileWriter(fl)) {
                fw.write("{\"Name\":\"" + filename + "\",\"Amount\":" + amount + ",\"Holdings\":{},\"transaction\":[]}");
                fw.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            System.out.println("File already exist");
        }
        setFilename(fl.getPath());
        readJSON();
    }

    public boolean openJSON(String filename) {
        File fl = new File("jsonfolder/" + filename + ".json");
        if (fl.exists()) {
            setFilename(fl.getPath());
            readJSON();
            return true;
        } else {
            System.out.println("Account not exist. create new account!!");
            return false;
        }
    }

    public void readJSON() {
        try (FileReader fr = new FileReader(getFilename())) {
            JSONParser pr = new JSONParser();
            setBaseobjuser((JSONObject) pr.parse(fr));
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    public void writeJSON() {
        try(FileWriter fw=new FileWriter(getFilename())){
            fw.write(getBaseobjuser().toJSONString());
            fw.flush();
            System.out.println("Account File saved!!!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
