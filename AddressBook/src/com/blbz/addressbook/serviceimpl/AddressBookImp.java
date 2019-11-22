package com.blbz.addressbook.serviceimpl;

import com.blbz.addressbook.model.AddressBookModel;
import com.blbz.addressbook.repository.AddressBookFileHandaling;
import com.blbz.addressbook.service.AddressBook;
import org.json.simple.JSONObject;

import java.util.HashMap;

public class AddressBookImp implements AddressBook {
    @Override
    public void addPerson(String key, String detail) {

        HashMap<String, String> tmp = new HashMap<>() ;
        HashMap old=AddressBookModel.getPersion();
        String[] s= detail.split("@");
        for (int i = 0; i <s.length ; i=i+2) {
            tmp.put(s[i],s[i+1]);
        }
        old.put(key,tmp);
        AddressBookModel.setPersion(old);
    }

    @Override
    public void savePerson() {
        JSONObject jobj= AddressBookFileHandaling.readJson();
        jobj.putAll(AddressBookModel.getPersion());
        AddressBookFileHandaling.writeJSON(jobj);

    }
}
