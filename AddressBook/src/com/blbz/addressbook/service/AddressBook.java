package com.blbz.addressbook.service;

public interface AddressBook {
    void addPerson(String key,String detail);
    void savePerson();
    void saveasPerson();
    void editPerson(String fullname);
    void searchPerson(String name);
    void removePerson(String fullname);
}
