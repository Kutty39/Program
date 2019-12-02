package com.blbz.stockaccountnanagement.repository;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import static com.blbz.stockaccountnanagement.model.StockModel.*;

public class CompanyFileHandler {
    public void readCompanyJSON() {
        try (FileReader fr = new FileReader(getCompanyfilename())) {
            JSONParser pr = new JSONParser();
            setBaseobjcompany((JSONObject) pr.parse(fr));
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    public void writeCompanyJSON() {
        try(FileWriter fw=new FileWriter(getCompanyfilename())){
            fw.write(getBaseobjcompany().toJSONString());
            fw.flush();
            System.out.println("Company File saved!!!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
