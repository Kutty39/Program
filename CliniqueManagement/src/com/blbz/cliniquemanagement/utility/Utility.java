package com.blbz.cliniquemanagement.utility;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Utility {
    private static Scanner sc;

    public static String getDays(){
        String tmp="";
                do{}while (tmp.matches(""));
    }
    public static String getString() {
        String tmp="";
        do {
            tmp=sc.next();
        }while (!tmp.matches("\\D*\\s*\\D"));
        return tmp;
    }
    public static String getFreeText() {
        return sc.nextLine();
    }
    public static int getInt() {
        int val = 0;
        do {
            try {
                val = Integer.parseInt(sc.nextLine());
            } catch (InputMismatchException e) {
                val = 0;
            }
        } while (val == 0);
        return val;
    }
}
