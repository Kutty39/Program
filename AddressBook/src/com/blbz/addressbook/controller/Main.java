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


public class Main extends AddressBookModel {
    private static AddressBook addressBook;

    public static void main(String[] args) {
        setContinueflag(true);
        while (isContinueflag()) {
            System.out.println("Address Book Manager(ABM)");
            System.out.println("1.Create/Open address book\n2.Delete address book\n3.Exit");
            switch (Utility.getInt()) {
                case 1:
                    fileSelectionDelete("find");
                    personOperation();
                    setContinueflag(true);
                    break;
                case 2:
                    fileSelectionDelete("delete");
                    setContinueflag(true);
                    break;
                case 3:
                    System.out.println("Bye! Bye!!");
                    setContinueflag(false);
                    break;
                default:
                    System.out.println("Invalid selection");
                    break;

            }
        }

    }

    private static void personOperation() {
        setContinueflag(true);
        addressBook = new AddressBookImp();
        //get the user input
        while (isContinueflag()) {
            System.out.println("You are working on address book, \nname:" + AddressBookModel.getFilename() + "\n\n" + "Select any one option\n" +
                    "1.Add Person Detail\n" +
                    "2.Edit\n" +
                    "3.Delete\n" +
                    "4.Search\n" +
                    "5.Save\n" +
                    "6.Save as\n" +
                    "7.Exit");
            switch (Utility.getInt()) {//this will perform action on person add, update
                case 1:
                    personAddMenu();//function to add person detail
                    break;
                case 2:
                    do {
                        System.out.println("Enter the users first name with last name to edit.\n(eg. firstname lastename)");
                        addressBook.editPerson(Utility.getString(false, "search"));
                        System.out.println("Press 'e' to edit another person or Press any key to close");
                    } while (Utility.getString(false).toUpperCase().equals("E"));
                    break;
                case 3:
                    do {
                        System.out.println("Enter the users first name with last name to delete.\n(eg. firstname lastename)");
                        addressBook.removePerson(Utility.getString(false, "search"));
                        System.out.println("Press 'd' to edit another person or Press any key to close");
                    } while (Utility.getString(false).toUpperCase().equals("D"));
                    break;
                case 4:
                    do {
                        System.out.println("Please enter the name to search");
                        addressBook.searchPerson(Utility.getString(false, "search"));
                        System.out.println("Press 'y' to perform another search. any key to exit.");
                    } while (Utility.getString(false).toUpperCase().equals("Y"));
                    break;
                case 5:
                    addressBook.savePerson();//will save the changes what you made
                    break;
                case 6:
                    addressBook.saveasPerson();
                    break;
                case 7:
                    if (AddressBookModel.getPersion().size() > 0) {
                        System.out.println("You have unsaved data. press 'y' to save. any key to close.");
                        if (Utility.getString(false).toUpperCase().equals("Y")) {
                            addressBook.savePerson();
                        }
                    }
                    setContinueflag(false);
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
            }
        }
    }

    private static void fileSelectionDelete(String function) {
        List<String> filename = AddressBookFileHandaling.fileName();
        int pos = 0;
        if (filename.size() != 0) {
            System.out.println("Address book Selection Screen.");
            System.out.println("Please select the file you want to " + (function.equals("find") ? "work" : "delete"));
            for (String path : filename) {
                ++pos;
                System.out.println(pos + "." + (path.contains("Untitled") ? "New Book" : path));
            }
            int val = Utility.getInt();
            while (val > pos) {
                System.out.println("Enter valid file number");
                val = Utility.getInt();
            }
            if (function.equals("find")) {

                AddressBookModel.setFilename(filename.get(val - 1));

                System.out.println("File changed to " + filename.get(val - 1));
            } else {
                AddressBookFileHandaling.deleteJSOn();
            }
        } else {
            if (function.equals("find")) {
                System.out.println("New file created for you...");
                AddressBookModel.setFilename("Untitled.json");
            }
        }
        System.out.println("-------------------------*----------------*---------------*--------------------");
    }

    public static void personAddMenu() {
        String detail = "";
        System.out.println("Please enter the first name:");
        String key = Utility.getString(false);
        detail = "First Name@" + key;

        System.out.println("Please enter the last name:");
        String lst = Utility.getString(false);
        key = key + " " + lst;
        detail = detail + "@Last Name@" + lst;

        System.out.println("Please enter the address(use ',' for separator):");
        detail = detail + "@Address@" + Utility.getString(true);

        System.out.println("Please enter the city name:");
        detail = detail + "@City@" + Utility.getString(false);

        System.out.println("Please enter the state name:");
        detail = detail + "@State@" + Utility.getString(false);

        System.out.println("Please enter the zip:");
        detail = detail + "@Zip@" + Utility.getString(false, "Zip");

        System.out.println("Please enter the Phone number:");
        detail = detail + "@Phone@" + Utility.getString(false, "Ph");
        addressBook.addPerson(key, detail);

    }
}


