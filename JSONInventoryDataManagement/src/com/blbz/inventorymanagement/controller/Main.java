package com.blbz.inventorymanagement.controller;

/*
Created by : Mr. Tamilselvan S
Created on : 20/11/2019
Purpose of Creating : Provide interface to the user to add values in inventory JSON.
 */


import com.blbz.inventorymanagement.model.Inventory;
import com.blbz.inventorymanagement.service.InventoryManager;
import com.blbz.inventorymanagement.serviceimp.InventorySystem;
import com.blbz.inventorymanagement.util.Utility;

import java.util.InputMismatchException;


public class Main {
    private static InventoryManager invsys = new InventorySystem();

    public static void main(String[] args) {
        String option="";
        Inventory.setContinueflag(true);
        //This loop will run till you get the valid input, Like this loop i have used more while for getting valid inputs
        while (Inventory.isContinueflag()) {
            option="";
            System.out.println("Please select what action you want to perform?\n1.Add data\n2.Do calculation\n3.Exit");
            while (option.equals("")){
                option=Utility.getString();
            }
            switch (option) {//This switch for main menu
                case "1":
                    while (Inventory.isContinueflag()) {
                        option="";
                        System.out.println("What you want to add?\nPlease select from the below option:\n\n1.Rice\n2.Wheat\n3.pulses\n4.Exit");
                        while (option.equals("")){
                            option=Utility.getString();
                        }
                        switch (option) {//Adding the value to Json, it will pass the item to next level input
                            case "1":
                                secondLevelInputs("Rice");
                                break;
                            case "2":
                                secondLevelInputs("Wheat");
                                break;
                            case "3":
                                secondLevelInputs("Pulses");
                                break;
                            case "4":
                                Inventory.setContinueflag(false);
                                break;
                            default:
                                System.out.println("Wrong option!!!");
                                break;
                        }
                    }
                    Inventory.setContinueflag(true);
                    break;
                case "2":
                    while (Inventory.isContinueflag()) {//This switch for calculation
                        option="";
                        System.out.println("Please select from the below option:\n\n1.All inventory\n2.Rice\n3.Wheat\n4.Pulses\n5.Exit");
                        while (option.equals("")){
                            option=Utility.getString();
                        }
                        switch (option) {//this will call the calculate method with appropriate value
                            case "1":
                                System.out.println(invsys.calculate("All"));
                                break;
                            case "2":
                                System.out.println(invsys.calculate("Rice"));
                                break;
                            case "3":
                                System.out.println(invsys.calculate("Wheat"));
                                break;
                            case "4":
                                System.out.println(invsys.calculate("Pulses"));
                                break;
                            case "5":
                                Inventory.setContinueflag(false);
                                break;
                            default:

                                System.out.println("Wrong input!!");
                                break;
                        }
                    }
                    Inventory.setContinueflag(true);
                    break;
                case "3":
                    Inventory.setContinueflag(false);
                    break;
                default:
                    System.out.println("Wrong option!!!");
                    break;
            }
        }
    }


    // this method will generate next level inputs
    public static void secondLevelInputs(String item) {
        try {
            System.out.println("Enter name of the " + item);
            String name = Utility.getString();
            while(name.equals("")){
                name = Utility.getString();
            }
            System.out.println("Enter weight of the " + item);

            int weight = Utility.getInt();
            System.out.println("Enter price per kg");
            Double priceperkg = Utility.getDouble();

            //it will call the add method by which JSON file will get updated
            invsys.addItem(item, name, weight, priceperkg);
        } catch (InputMismatchException e) {
            System.out.print("\033[H\033[2J");
            System.out.println("Wrong input given");
        }
    }


}
