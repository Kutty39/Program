package com.company.util;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Utility {
    private static JSONObject rice, pulses, wheat;
    private static JSONArray name, weight, priceperkg;

    public static void JSONObjectAssigner() {
        File fl = new File("fils/InventeryJSON.json");
        try (FileReader fr = new FileReader(fl)) {
            if (fl.length() > 0) {
            } else {
                System.out.println("No data found");
            }
            JSONParser jsp = new JSONParser();
            JSONObject jsond = (JSONObject) jsp.parse(fr);
            rice = (JSONObject) jsond.get("Rice");
            name = (JSONArray) rice.get("Name");
            name.add("s");
            rice.put("Name", name);
            jsond.put("Rice", rice);
            FileWriter fw = new FileWriter("fils/InventeryJSON.json");
            fw.write(jsond.toString());
            fw.flush();
            fl = new File("fils/InventeryJSON.json");
            System.out.println(fl.toString());


        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }


    }
}
