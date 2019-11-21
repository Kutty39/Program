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
            //System.out.println(Inventory.getInv().toJSONString());
            /*FileWriter fr = Inventory.getFw();
            fr.write(Inventory.getInv().toString());
            fr.flush();*/
            fw.write(Inventory.getInv().toJSONString());
            fw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
