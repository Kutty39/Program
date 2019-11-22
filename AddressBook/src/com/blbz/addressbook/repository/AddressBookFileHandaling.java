package com.blbz.addressbook.repository;

import com.blbz.addressbook.Util.Utility;
import com.blbz.addressbook.model.AddressBookModel;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.swing.text.html.parser.Parser;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AddressBookFileHandaling {
    public static void writeJSON(JSONObject jsonObject) {
        if(AddressBookModel.getFilename().contains("Untitled")){
            System.out.println("Please enter the files name to save:");
            AddressBookModel.setFilename(Utility.getString(false));
        }
        try (FileWriter fw=new FileWriter(AddressBookModel.getFilename())){
            fw.write(jsonObject.toString());
            fw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static JSONObject readJson() {
        String file=AddressBookModel.getFilename();
        try(FileReader fr=new FileReader(file)){
            return (JSONObject) new JSONParser().parse(fr);
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean search(String key) {
        return false;
    }

    public static List<String> fileName() {
        try (FileWriter fw = new FileWriter(new File("Jsonfolder/Untitled.json"))) {
            List<String> result = new ArrayList<>();
            File dic = new File("/Jsonfolder");
            File[] diclsit = dic.listFiles();
            if (diclsit == null) {

                fw.write("{}");
                fw.flush();
                result.add("Untitled.json");
            } else {
                for (File f : diclsit) {
                    if (f.isFile()) {
                        result.add(f.getName());
                    }
                }
            }
            return result;
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
            return null;
        }

    }
}
