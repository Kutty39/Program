package com.blbz.addressbook.repository;

import com.blbz.addressbook.Util.Utility;
import com.blbz.addressbook.model.AddressBookModel;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.swing.text.html.parser.Parser;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AddressBookFileHandaling {
    public static void writeJSON(JSONObject jsonObject) {
        if (AddressBookModel.getFilename().contains("Untitled")) {
            System.out.println("Please enter the files name to save:");
            String filename=Utility.getString(false);
            if(!filename.contains("*.json")){
                filename=filename+".json";
            }
            AddressBookModel.setFilename(filename);
        }
        try (FileWriter fw = new FileWriter(AddressBookModel.getFilename())) {
            fw.write(jsonObject.toString());
            fw.flush();
            AddressBookModel.setPersion(null);
            System.out.println("Successfully saved!!!");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void deleteJSOn(){
        File fl=new File(AddressBookModel.getFilename());
        if(fl.delete()){
            System.out.println("Successfully deleted");
        }else {
            System.out.println("Something went wrong!!!!");
        }
    }

    public static JSONObject readJson() {
        String file = AddressBookModel.getFilename();
        try (FileReader fr = new FileReader(file)) {
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
        try (Stream<Path> paths = Files.walk(Paths.get("Jsonfolder/"))) {
            List<String> result = paths.filter(Files::isRegularFile).map(path -> path.getFileName().toString()).collect(Collectors.toList());
            if (result.size() == 0) {
                FileWriter fw = new FileWriter(new File("Jsonfolder/Untitled.json"));
                fw.write("{}");
                fw.flush();
                fw.close();
            }
            return result;
        } catch (IOException |
                NullPointerException e) {
            e.printStackTrace();
            return null;
        }

    }
}
