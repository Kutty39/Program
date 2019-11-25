package com.blbz.addressbook.Util;
/*
Created by : Mr. Tamilselvan S
Created on : 21/11/2019
Purpose of Creating : This class will have all the common purpose methods
 */

import java.util.Scanner;
import java.util.regex.Pattern;

public class Utility {
    private static Scanner sc = new Scanner(System.in);

    //reading string input
    public static String getString(boolean address, String... field) {
        String inputstring = "";
        while (inputstring.equals("")) {
            sc.reset();
            inputstring = sc.nextLine().trim();
            if (!address) {
                if (field.length > 0) {
                    //for zip, it will check for 6 numbers
                    if (field[0].equals("Zip")) {
                        if (!Pattern.matches("\\d{6}", inputstring)) {
                            System.out.println("Please enter valid zip");
                            inputstring = "";
                        }
                    } else if (field[0].equals("Ph")) {//for phone, it will check for 10 numbers
                        if (!Pattern.matches("\\d{10}", inputstring)) {
                            System.out.println("Please enter valid phone number");
                            inputstring = "";
                        }
                    } else if (field[0].equals("search")) {//search is a free text with out number
                        if (!Pattern.matches("\\D*", inputstring)) {
                            System.out.println("Please enter valid name");
                            inputstring = "";
                        }
                    }
                } else if (!Pattern.matches("[a-zA-z]*[\\s]?[a-zA-z]*", inputstring)) {//name format can have space between
                    System.out.println("Please enter valid string");
                    inputstring = "";
                }
            }
        }
        return inputstring;
    }

    //reading int input
    public static int getInt() {
        boolean continueflag = true;
        int val = 0;
        while (continueflag) {
            try {
                sc.reset();
                val = Integer.parseInt(sc.nextLine().trim());
                continueflag = false;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! enter again");
                continueflag = true;
            }
        }
        return val;
    }


}