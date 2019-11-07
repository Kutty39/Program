package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("1.Fewest Notes\nSelect any option from the above:");
        Scanner in = new Scanner(System.in);
        in.reset();
        switch (in.nextLine()) {
            case "1":
                int amount = 0;
                FewestNotes fewestNotes = new FewestNotes();
                int[][] a = fewestNotes.Notescount(5469);
                int notecount = fewestNotes.getNotecount();
                System.out.println("No of note given is :" + notecount);
                System.out.println("Rs Notes and Counts :");
                for (int[] rw : a) {
                    amount = amount + (rw[0] * rw[1]);
                    System.out.println(rw[0] + "*" + rw[1] + "=" + (rw[0] * rw[1]));
                }
                System.out.println("In total :" + amount);
                break;
            default:
                System.out.println("Bye Bye!!!!");
        }

    }
}
