package com.blbz.algorithm.base;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MessagePrinter {

    static String replace() {
        Scanner sc = new Scanner(System.in);
        String message = "Hello <<name>>, We have your full name as <<full name>> in our system. your contact number is 91-xxxxxxxxxx. Please,let us know in case of any clarification Thank you BridgeLabz 01/01/2016.";
        String[] patternes = {"[a-bA-z]*\\s?[a-bA-z]*", "[a-bA-z]*\\s?[a-bA-z]*", "[0-9]{10}", "[0-9]{2}/[0-9]{2}/[0-9]{4}"};
        String[] name = {"Name", "Full name", "Mobile number(10 digit)", "Date(DD/MM/YYYY)"};


        int count = 0;

        for (int i = 0; i < patternes.length; i++) {
            System.out.println("Enter " + name[i]);
            do {
                sc.reset();
                String input = sc.nextLine();
                Pattern p = Pattern.compile(patternes[i]);
                Matcher m = p.matcher(input);
                count = 0;
                while (m.find()) {
                    ++count;
                }
                if (count == 0) {
                    System.out.println("Valid " + name[i] + " please");
                } else {
                    if (i == 0) {
                        message = message.replace("<<name>>", input);
                    } else if (i == 1) {
                        message = message.replace("<<full name>>", input);
                    } else if (i == 2) {
                        message = message.replace("xxxxxxxxxx", input);
                    } else {
                        message=message.replaceAll(patternes[i],input);
                    }
                }
            } while (count == 0);
        }


        return message;
    }

    ;
}
