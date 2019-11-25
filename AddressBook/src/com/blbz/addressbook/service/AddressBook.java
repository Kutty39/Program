package com.blbz.addressbook.service;
/*
Created by : Tamilselvan S.
Created on : 22/11/2019.
Purpose : All the method is here.
 */
public interface AddressBook {
    void addPerson(String key,String detail);
    void savePerson();
    void saveasPerson();
    void editPerson(String fullname);
    void searchPerson(String name);
    void removePerson(String fullname);
}
