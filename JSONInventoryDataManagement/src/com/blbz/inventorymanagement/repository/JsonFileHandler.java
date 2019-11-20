package com.blbz.inventorymanagement.repository;


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

    public void objectCreator() {
        try {
            createJsonIfnotFound();
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
            Inventory.setFl("fils/InventeryJSON.json");
            if (Inventory.getFl().createNewFile()) {
                try (FileWriter fileWriter = new FileWriter(Inventory.getFl())) {
                    fileWriter.write("{\n" +
                            "  \"Inv\":{\n" +
                            "  \"Rice\" :{\"Name\":[],\"Weight\":[],\"Price Per kg\":[]},\n" +
                            "  \"wheat\":{\"Name\":[],\"Weight\":[],\"Price Per kg\":[]},\n" +
                            "  \"Pulses\":{\"Name\":[],\"Weight\":[],\"Price Per kg\":[]}\n" +
                            "}\n" +
                            "}");
                    fileWriter.flush();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
    This method will save the Json file
     */
    public void saveJson() {
        try {
            Inventory.getFw().write(Inventory.getInv().toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
