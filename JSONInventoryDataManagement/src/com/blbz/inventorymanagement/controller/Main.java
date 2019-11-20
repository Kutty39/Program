package com.blbz.inventorymanagement.controller;

/*
Created by : Mr. Tamilselvan S
Created on : 20/11/2019
Purpose of Creating : Provide interface to the user to add values in inventory JSON.
 */


import com.blbz.inventorymanagement.service.InventoryManager;
import com.blbz.inventorymanagement.serviceimp.InventorySystem;
import com.blbz.inventorymanagement.util.Utility;

import java.util.InputMismatchException;


public class Main {
    public static void main(String[] args) {
        System.out.println("Please select what action you want to perform?\n1.Add data\n2.Do calculation");
        switch (Utility.getString()) {
            case "1":
                System.out.println("What you want to add?\nPlease select from the below option:\n\n1.Rice\n2.Wheat\n3.pulses");
                switch (Utility.getString()) {//it will pass the item to next level input
                    case "1":
                        secondLevelInputs("Rice");
                        break;
                    case "2":
                        secondLevelInputs("Wheat");
                        break;
                    case "3":
                        secondLevelInputs("Pulses");
                        break;
                    default:
                        System.out.println("Wrong option!!!");
                }
                break;
            case "2":
                System.out.println("Please select from the below option:\n\n1.Add all inventory\n2.Rice\n3.Wheat\n4.Pulses");
                switch (Utility.getString()) {
                    case "1":
                        break;
                    case "2":
                        break;
                    case "3":
                        break;
                    case "4":
                        break;
                    default:
                        System.out.println("Wrong input!!");
                }
                break;
            default:
                System.out.println("Wrong option!!!");
                break;
        }
    }


    // this method will generate next level inputs
    public static void secondLevelInputs(String option) {
        try {
            InventoryManager invsys = new InventorySystem();
            System.out.println("Enter name of the " + option);
            String name = Utility.getString();
            System.out.println("Enter weight of the " + option);
            int weight = Utility.getInt();
            System.out.println("Enter price per kg");
            Double priceperkg = Utility.getDouble();

            //it will call the add method by which JSON file will get updated
            invsys.addItem(option, name, weight, priceperkg);
        } catch (InputMismatchException e) {
            System.out.println("Wrong input given");
        }
    }


}
