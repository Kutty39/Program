package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("1.Fewest Notes\nSelect any option from the above:");
        Scanner in = new Scanner(System.in);
        in.reset();
        switch (in.nextLine()) {
            case "1":
                FewestNotes fewestNotes = new FewestNotes();
                break;
            default:
                System.out.println("Bye Bye!!!!");
        }

    }
}
