package com.blbz.inventorymanagement.serviceimp;

/*
Created by : Mr. Tamilselvan S
Created on : 20/11/2019
Purpose of Creating : Implementation of the interface is here.
 */

import com.blbz.inventorymanagement.model.Inventory;
import com.blbz.inventorymanagement.repository.JsonFileHandler;
import com.blbz.inventorymanagement.service.InventoryManager;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.Iterator;

public class InventorySystem implements InventoryManager {
    JsonFileHandler jfh = new JsonFileHandler();//this will use for all the file operations

    /*
    By implementing the methode we are adding datas into JSON file.
    in this we need name of the item
    weight of the item
    price per kg
     */
    @Override
    public void addItem(String item, String itemname, double weight, double priceperkg) {
        jfh.createJsonIfnotFound();
        jfh.objectCreator();//this method will create the base object for the JSON.
        JSONObject mainObject = Inventory.getInv();//getting the base object through getter and storing
        JSONObject jsonObject = (JSONObject) mainObject.get("Inv");//getting the first object form base object

        JSONObject jsonItem = (JSONObject) jsonObject.get(item);//getting the Jsonobject with item name
        JSONArray jsonArray = (JSONArray) jsonItem.get("Name");//getting the json array with keys
        jsonArray.add(itemname);//adding the value into array. continue the same for next two objects

        jsonArray = (JSONArray) jsonItem.get("Weight");
        jsonArray.add(weight);

        jsonArray = (JSONArray) jsonItem.get("Price Per kg");
        jsonArray.add(priceperkg);

        //Inventory.setInv(mainObject);
        jfh.saveJson();//to save the json
    }

    @Override
    public double calculate(String option) {
        double total = 0;
        JSONObject tmpobj;
        jfh.objectCreator();
        JSONObject base = (JSONObject) Inventory.getInv().get("Inv");
        if (!option.equals("All")) {
            base = (JSONObject) base.get(option);
            total = total + totalprice(option, base);
        } else {
            for (Object obj : base.keySet()) {
                tmpobj = (JSONObject) base.get(obj);
                total = total + totalprice((String) obj, tmpobj);
            }
        }
        System.out.println("Overall - " + total);
        return total;
    }

    private double totalprice(String itemname, JSONObject obj) {
        JSONArray tmparray, tmparray1;
        int pos = 0;
        double objtotal = 0;
        tmparray = (JSONArray) obj.get("Weight");
        tmparray1 = (JSONArray) obj.get("Price Per kg");
        Iterator it = tmparray.iterator();
        while (it.hasNext()) {
            objtotal = objtotal + (double) it.next() * (double) tmparray1.get(pos);
            ++pos;
        }
        pos = 0;
        System.out.println(itemname + " - " + objtotal);
        return objtotal;
    }

}
