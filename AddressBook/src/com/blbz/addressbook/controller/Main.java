package com.blbz.addressbook.controller;

/*
Created by : Tamilselvan S.
Created on : 22/11/2019.
Purpose : User interface to work with address book.
 */

import com.blbz.addressbook.Util.Utility;
import com.blbz.addressbook.model.AddressBookModel;
import com.blbz.addressbook.repository.AddressBookFileHandaling;
import com.blbz.addressbook.service.AddressBook;
import com.blbz.addressbook.serviceimpl.AddressBookImp;

import java.util.List;
import java.util.Objects;


public class Main extends AddressBookModel {
   private static AddressBook addressBook;

    public static void main(String[] args) {
        fileSelection();
        setContinueflag(true);
        //get the user input
        while (isContinueflag()) {
            System.out.println("Select any one option\n" +
                    "1.Add Person Detail\n" +
                    "2.Edit\n" +
                    "3.Delete\n" +
                    "4.Search\n" +
                    "5.Save\n" +
                    "6.To create,change,edit and delete address book\n" +
                    "7.Exit");
            switch (Utility.getInt("option")) {//this will perform action on person add, update
                case 1:
                    personAddMenu();//function to add person detail
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    addressBook.savePerson();//will save the changes what you made
                    break;
                case 6:
                    System.out.println("Bye! Bye!!");
                    setContinueflag(false);
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
            }
        }
    }

    public static void fileSelection() {
        List<String> filename = AddressBookFileHandaling.fileName();
        int pos = 0;
        System.out.println("Address book Selection Screen.");
        System.out.println("Below we will show the Address book. please press \"y\" to work on that file.");
        for (String path : Objects.requireNonNull(filename)) {
            ++pos;
            System.out.println(pos + "." + path);
        }
        int val = Utility.getInt("");
        while (val > pos) {
            System.out.println("Enter valid date");
            val = Utility.getInt("");
        }
        AddressBookModel.setFilename(filename.get(val - 1));
        System.out.println("-------------------------*----------------*---------------*--------------------");
    }

    public static void personAddMenu() {
        addressBook = new AddressBookImp();
        String detail = "";
        System.out.println("Please enter the first name:");
        String key = Utility.getString(false);
        detail = "First Name@" + key;

        System.out.println("Please enter the last name:");
        key = key + " " + Utility.getString(false);
        detail = detail + "@Last Name@" + key;

        System.out.println("Please enter the address(use ',' for separator):");
        detail = detail + "@Address@" + Utility.getString(true);

        System.out.println("Please enter the city name:");
        detail = detail + "@City@" + Utility.getString(false);

        System.out.println("Please enter the state name:");
        detail = detail + "@State@" + Utility.getString(false);

        System.out.println("Please enter the zip:");
        detail = detail + "@Zip@" + Utility.getInt("Zip");

        System.out.println("Please enter the Phone number:");
        detail = detail + "@Phone@" + Utility.getInt("Ph");
        addressBook.addPerson(key, detail);

    }
}


