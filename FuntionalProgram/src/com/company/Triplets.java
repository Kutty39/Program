package com.company;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Triplets {
    static int itg;

    public static void tripletfinder() {
        int i = 0,cnt=0;
        int[] n;

        String tmp = "";
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the No. of integers you want");
        sc.reset();
        tmp = sc.nextLine();
        if (isint(tmp)) {
            n = new int[itg];
            System.out.println("Enter the integers and press Q to finish the process");
            for (int j = 0; j < n.length; j++) {
                sc.reset();
                tmp = sc.nextLine();
                while (!isint(tmp)) {
                    sc.reset();
                    tmp = sc.nextLine();
                }
                n[i] = itg;
                ++i;
            }
            for (int j = 0; j < n.length; j++) {
                for (int k = 0; k < n.length; k++) {
                    if (k != j) {
                        for (int l = 0; l < n.length; l++) {
                            if (l != j && l!=k){
                                if(n[j]+n[k]+n[l]==0){
                                    ++cnt;
                                    System.out.println("(i,j,k) is ("+j+","+k+","+l+") and triplet is "+n[j]+","+n[k]+","+n[l]);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private static boolean isint(String tmp) {
        try {
            itg = Integer.parseInt(tmp);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
