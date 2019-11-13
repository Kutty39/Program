package com.company;

import java.io.IOException;

import static com.company.Utillity.*;

public class Main {

    public static void main(String[] args) {
        sc.reset();//initiating Scanner
        UnOrderedList<String> list = new UnOrderedList<>();//initiating list class

        try {
            /*
            Reading data from a file with utility class and add the string value into list
             */
            for (String s : readlistfile()) {
                list.add(s);
            }

            /*
            getting input from user to search the text in list
             */
            System.out.println("Please enter a word to search");
            System.out.println(list.searchAdd(sc.nextLine()));
        } catch (IOException e) {
            System.out.println("Problem with file");
        }
    }
}
