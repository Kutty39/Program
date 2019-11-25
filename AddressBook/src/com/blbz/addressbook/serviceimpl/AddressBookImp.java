package com.blbz.addressbook.serviceimpl;

/*
Created by : Tamilselvan S.
Created on : 22/11/2019.
Purpose : implementation of all the methods.
 */

import com.blbz.addressbook.Util.Utility;
import com.blbz.addressbook.model.AddressBookModel;
import com.blbz.addressbook.repository.AddressBookFileHandaling;
import com.blbz.addressbook.service.AddressBook;
import org.json.simple.JSONObject;

import java.util.HashMap;

public class AddressBookImp implements AddressBook {
    //Read the json and store the old value into person object
    public AddressBookImp() {
        AddressBookModel.setPersion(AddressBookFileHandaling.readJson());
    }

    //to add person detail into person object
    @Override
    public void addPerson(String key, String detail) {

        HashMap tmp = new HashMap();
        HashMap old = AddressBookModel.getPersion();
        String[] s = detail.split("@");
        for (int i = 0; i < s.length; i = i + 2) {
            tmp.put(s[i], s[i + 1]);
        }
        old.put(key, tmp);
        AddressBookModel.setPersion(old);
    }

    //it will save person object into json
    @Override
    public void savePerson() {
        JSONObject jobj = (JSONObject) AddressBookModel.getPersion();
        jobj.putAll(AddressBookModel.getPersion());
        AddressBookFileHandaling.writeJSON(jobj);

    }

    //save-as the current json
    @Override
    public void saveasPerson() {

        JSONObject jobj = (JSONObject) AddressBookModel.getPersion();
        AddressBookModel.setFilename("Untitled");
        AddressBookFileHandaling.writeJSON(jobj);
    }

    //edit the existing detail
    @Override
    public void editPerson(String fullname) {
        JSONObject jobj = AddressBookFileHandaling.readJson();
        if (jobj.get(fullname) != null) {
            JSONObject foundedobj = (JSONObject) jobj.get(fullname);
            //for each loop-> will ask the user with one by one whether he/she wants to edit
            foundedobj.forEach((k, v) -> {
                if (!k.equals("First Name") && !k.equals("Last Name")) {
                    System.out.println(k + " " + v);
                    System.out.println("want to change the value, press 'y'. any key to move next");
                    if (Utility.getString(false).toUpperCase().equals("Y")) {
                        System.out.println("Enter new " + k);
                        //change the updated value into the same object
                        foundedobj.put(k, Utility.getString((k == "Address"), (k.equals("Phone") ? "Ph" : (k.equals("Zip") ? "Zip" : "search"))));
                    }
                }
            });
            // set the updated value into person
            AddressBookModel.setPersion(jobj);
        } else {
            System.out.println("Name is not found");
        }
    }

    //search person with name key
    @Override
    public void searchPerson(String fullname) {
        JSONObject jobj = AddressBookFileHandaling.readJson();
        //for each loop-> will go through all the object
        jobj.forEach((k, v) -> {
            if (String.valueOf(k).contains(fullname)) {
                JSONObject tmp = (JSONObject) v;
                //printing part-> it will print if the data found
                tmp.forEach((k1, v1) -> System.out.println(k1 + "\t:\t" + v1));
                System.out.println("------------------***-------------------***-----------------");
            }
        });
    }

    //deleting the person
    @Override
    public void removePerson(String fullname) {
        JSONObject jobj = AddressBookFileHandaling.readJson();
        if (jobj.get(fullname) != null) {
            jobj.remove(fullname);
            AddressBookModel.setPersion(jobj);
            System.out.println("Data removed!!");
        } else {
            System.out.println("Name is not found");
        }
    }

}
