package com.arry;

import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Arry {
    public String[][] createArry(){
        String[][] a = null;
        try {
            Scanner in = new Scanner(System.in);
            in.reset();
            System.out.println("Enter row count :");
            int i = in.nextInt();
            in.reset();
            System.out.println("Enter column count :");
            int j = in.nextInt();
            a = new String[i][j];
            for (int k = 0; k < i; k++) {
                for (int l = 0; l < j; l++) {
                    in.reset();
                    System.out.println("Enter value for (@) :".replace("@",k+","+l));
                    a[k][l] = in.next();
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Enter valid number");
        }
        return a;
    }
    public void PrintArray(String[][] ary) {
        PrintWriter pw = new PrintWriter(System.out);
        for (int k = 0; k < ary.length; k++) {
            for (int l = 0; l < ary[0].length; l++) {
                pw.print(ary[k][l]+"|");
                pw.flush();
            }
            pw.println();
        }
    }
}
