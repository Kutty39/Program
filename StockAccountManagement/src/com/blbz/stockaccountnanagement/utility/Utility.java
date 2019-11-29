package com.blbz.stockaccountnanagement.utility;

import java.util.Scanner;

public class Utility {
    Scanner sc = new Scanner(System.in);

    public String getInputString(String... s) {
        sc.reset();
        return sc.nextLine();
    }

    public int getInput() {
        int val = 0;
        sc.reset();
        try {
            val = Integer.parseInt(sc.nextLine());
            return val;
        } catch (Exception e) {
            System.out.println("Enter valid number");
            return getInput();
        }
    }

    public double getInputDouble() {
        double val = 0;
        sc.reset();
        try {
            val = Double.parseDouble(sc.nextLine());
            return val;
        } catch (Exception e) {
            System.out.println("Enter valid number");
            return getInputDouble();
        }
    }
}
