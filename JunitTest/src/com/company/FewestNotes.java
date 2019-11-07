package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

class FewestNotes {
    private final static int[] notes = {1, 2, 5, 10, 50, 100, 500, 1000};

    FewestNotes() {
        try {
            int notecount = 0;
            int[][] notelist;
            int j = 0;
            int tmpamount;

            Scanner sc = new Scanner(System.in);
            System.out.println("Please enter the amount to be changed :");
            int amount = sc.nextInt();
            tmpamount= amount;
            notelist = new int[notes.length][2];
            for (int i = notes.length-1; i >= 0; i--) {
                while (notes[i] <= tmpamount) {
                    tmpamount = tmpamount - notes[i];
                    notelist[j][0] = notes[i];
                    ++notelist[j][1];
                    ++notecount;
                }
                ++j;
            }
            System.out.println("No of note given is :" + notecount);
            System.out.println("Rs Notes and Counts :");
            for (int[] rw:notelist) {
                if (rw[1] != 0) {
                    System.out.println(rw[0] + "*" + rw[1] + "=" + (rw[0]* rw[1]));
                }
            }
            System.out.println("In total :"+amount);
        } catch (InputMismatchException e) {
            System.out.println("Please enter valid number (Dot(.) is a stop :) Don't use it.)");
        }
    }
}
