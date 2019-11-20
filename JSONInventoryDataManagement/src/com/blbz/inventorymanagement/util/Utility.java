package com.blbz.inventorymanagement.util;

/*
Created by : Mr. Tamilselvan S
Created on : 20/11/2019
Purpose of Creating : This class will have all the common purpose methods and variables
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class Utility {
    static Scanner sc = new Scanner(System.in);

    public static String getString(){//reading string input
        sc.reset();
        return sc.nextLine();
    }

    public static int getInt() throws InputMismatchException  {//reading int input
        sc.reset();
        return sc.nextInt();
    }

    public static double getDouble() throws InputMismatchException  {//reading double input
        sc.reset();
        return sc.nextDouble();
    }

}
