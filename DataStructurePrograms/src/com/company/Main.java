package com.company;

import java.io.IOException;

import static com.company.Utillity.*;

public class Main {

    public static void main(String[] args) {
        sc.reset();//initiating Scanner
        //UnOrderedList<String> list = new UnOrderedList<>();//initiating list class
        OrderedList<Integer> ordlist = new OrderedList<>();//initiating Ordered list class

        try {
            /*
            Reading data from a file with utility class and add the string value into list
             */
            for (String s : readlistfile()) {
                ordlist.add(Integer.parseInt(s));
            }

            /*
            getting input from user to search the text in list
             */
            printlist(ordlist.head);
            System.out.println(ordlist.size());
            System.out.println("Please enter a number to search");
            //ordlist.remove(1);
            System.out.println(ordlist.pop());
            System.out.println(ordlist.pop());
            System.out.println(ordlist.pop());
            printlist(ordlist.head);
            System.out.println("pop index 2"+ordlist.pop(6));
            printlist(ordlist.head);

        } catch (IOException e) {
            System.out.println("Problem with file");
        }
    }
}
