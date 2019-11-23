package com.blbz.addressbook.Util;
/*
Created by : Mr. Tamilselvan S
Created on : 21/11/2019
Purpose of Creating : This class will have all the common purpose methods and variables
 */

import java.util.Scanner;
import java.util.regex.Pattern;

public class Utility {
    private static Scanner sc = new Scanner(System.in);

    public static String getString(boolean address, String... field) {//reading string input
        String inputstring = "";
        while (inputstring.equals("")) {
            sc.reset();
            inputstring = sc.nextLine().trim();
            if (!address) {
                if (field.length > 0) {
                    if (field[0].equals("Zip")) {
                        if (!Pattern.matches("\\d{6}", inputstring)) {
                            System.out.println("Please enter valid zip");
                            inputstring = "";
                        }
                    } else if (field[0].equals("Ph")) {
                        if (!Pattern.matches("\\d{10}", inputstring)) {
                            System.out.println("Please enter valid phone number");
                            inputstring = "";
                        }
                    }else if (field[0].equals("search")) {
                        if (!Pattern.matches("\\D*", inputstring)) {
                            System.out.println("Please enter valid name");
                            inputstring = "";
                        }
                    }
                } else if (!Pattern.matches("[a-zA-z]*[\\s]?[a-zA-z]*", inputstring)) {
                    System.out.println("Please enter valid string");
                    inputstring = "";
                }
            }
        }
        return inputstring;
    }

    public static int getInt() {//reading int input
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