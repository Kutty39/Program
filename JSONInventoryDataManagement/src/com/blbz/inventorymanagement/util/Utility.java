package com.blbz.inventorymanagement.util;

/*
Created by : Mr. Tamilselvan S
Created on : 20/11/2019
Purpose of Creating : This class will have all the common purpose methods and variables
 */

import java.util.Scanner;

public class Utility {
    static Scanner sc = new Scanner(System.in);

    public static String getString() {//reading string input
        sc.reset();
        return sc.nextLine();
    }

    public static int getInt() {//reading int input
        int val = 0;
        while (val == 0) {
            try {
                sc.reset();
                val = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                val = 0;
            }
        }
        return val;
    }

    public static double getDouble() {//reading double input
        double val = 0;
        while (val == 0) {
            try {
                sc.reset();
                val = Double.parseDouble(sc.nextLine());
            } catch (Exception e) {
                val = 0;
            }
        }
        return val;
    }

}
