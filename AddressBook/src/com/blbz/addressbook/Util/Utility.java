package com.blbz.addressbook.Util;
/*
Created by : Mr. Tamilselvan S
Created on : 21/11/2019
Purpose of Creating : This class will have all the common purpose methods and variables
 */

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Utility {
    static Scanner sc = new Scanner(System.in);
    static String inputstring = "";
    static boolean continueflag = false;

    public static String getString(boolean address) {//reading string input
        inputstring = "";
        while (inputstring.equals("")) {
            sc.reset();
            inputstring = sc.nextLine();
            if (!address) {
                if (!Pattern.matches("\\D*[^\\s]", inputstring)) {
                    System.out.println("Please enter valid string");
                    inputstring = "";
                }
            }
        }
        return inputstring;
    }

    public static int getInt(String field) {//reading int input
        continueflag = true;
        int val = 0;
        while (continueflag) {
            try {
                sc.reset();
                val = Integer.parseInt(sc.nextLine());
                if (field.equals("Zip")) {
                    if (Pattern.matches("[0-9]{6}", String.valueOf(val))) {
                        continueflag = false;
                    } else {
                        System.out.println("Please enter valid zip");
                    }
                } else if (field.equals("Ph")) {
                    if (Pattern.matches("[0-9]{10}", String.valueOf(val))) {
                        continueflag = false;
                    } else {
                        System.out.println("Please enter valid phone number");
                    }
                } else {
                    continueflag = false;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! enter again");
                continueflag = true;
            }
        }
        return val;
    }

    public static double getDouble() throws InputMismatchException {//reading double input
        sc.reset();
        return sc.nextDouble();
    }

}