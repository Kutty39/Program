package com.blbz.addressbook.serviceimpl;

import com.blbz.addressbook.Util.Utility;
import com.blbz.addressbook.model.AddressBookModel;
import com.blbz.addressbook.repository.AddressBookFileHandaling;
import com.blbz.addressbook.service.AddressBook;
import org.json.simple.JSONObject;

import java.util.HashMap;

public class AddressBookImp implements AddressBook {
    public AddressBookImp(){
        AddressBookModel.setPersion(AddressBookFileHandaling.readJson());
    }
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

    @Override
    public void savePerson() {
        JSONObject jobj= (JSONObject) AddressBookModel.getPersion();
        jobj.putAll(AddressBookModel.getPersion());
        AddressBookFileHandaling.writeJSON(jobj);

    }

    @Override
    public void saveasPerson() {

        JSONObject jobj= (JSONObject) AddressBookModel.getPersion();
        AddressBookModel.setFilename("Untitled");
        AddressBookFileHandaling.writeJSON(jobj);
    }

    @Override
    public void editPerson(String fullname) {
        JSONObject jobj = AddressBookFileHandaling.readJson();
        if (jobj.get(fullname) != null) {
            JSONObject foundedobj = (JSONObject) jobj.get(fullname);
            foundedobj.forEach((k, v) -> {
                System.out.println(k + " " + v);
                System.out.println("want to change the value, press 'y'. any key to move next");
                if (Utility.getString(false).toUpperCase().equals("Y")) {
                    System.out.println("Enter new " + k);
                    foundedobj.put(k, Utility.getString((k == "Address"), (k.equals("Phone") ? "Ph" : (k.equals("Zip") ? "Zip" : "search"))));
                }
            });
            AddressBookModel.setPersion(jobj);
        }else{
            System.out.println("Name is not found");
        }
    }

    @Override
    public void searchPerson(String fullname) {
        JSONObject jobj = AddressBookFileHandaling.readJson();
        jobj.forEach((k, v) -> {
            if (String.valueOf(k).contains(fullname)) {
                JSONObject tmp = (JSONObject) v;
                tmp.forEach((k1, v1) -> System.out.println(k1 + "\t:\t" + v1));
                System.out.println("------------------***-------------------***-----------------");
            }
        });
    }

    @Override
    public void removePerson(String fullname) {
        JSONObject jobj = AddressBookFileHandaling.readJson();
        if (jobj.get(fullname) != null) {
            jobj.remove(fullname);
            System.out.println(jobj.toString());
            AddressBookModel.setPersion(jobj);
            System.out.println(AddressBookModel.getPersion().toString());
        } else {
            System.out.println("Name is not found");
        }
    }

}
