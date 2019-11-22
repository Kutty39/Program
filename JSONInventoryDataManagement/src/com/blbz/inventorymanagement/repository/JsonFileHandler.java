package com.blbz.inventorymanagement.repository;

/*
Created by : Mr. Tamilselvan S
Created on : 20/11/2019
Purpose of Creating : This is to perform all file level operations
 */


import com.blbz.inventorymanagement.model.Inventory;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileWriter;
import java.io.IOException;


public class JsonFileHandler {


    // Inventory inventory=new Inventory();
    public static void main(String[] args) {
        //getJsonObject();
    }

    // this will read the base JSON file and store it into one object
    public void objectCreator() {
        try {
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = ((JSONObject) jsonParser.parse(Inventory.getFr()));
            Inventory.setInv(jsonObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
    This method will create the file if it is not available with default string
     */
    public void createJsonIfnotFound() {

        try {
            if (Inventory.getFl().createNewFile()) {
                FileWriter fw=new FileWriter(Inventory.getFl());
                fw.write("{\n" +
                        "  \"Inv\":{\n" +
                        "  \"Rice\" :{\"Name\":[],\"Weight\":[],\"Price Per kg\":[]},\n" +
                        "  \"Wheat\":{\"Name\":[],\"Weight\":[],\"Price Per kg\":[]},\n" +
                        "  \"Pulses\":{\"Name\":[],\"Weight\":[],\"Price Per kg\":[]}\n" +
                        "}\n" +
                        "}");
                fw.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
    This method will save the Json file
     */
    public void saveJson() {
        try (FileWriter fw=new FileWriter(Inventory.getFl());){
            fw.write(Inventory.getInv().toJSONString());
            fw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
