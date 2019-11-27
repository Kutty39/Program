package com.blbz.cliniquemanagement.utility;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Utility {
    private static Scanner sc = new Scanner(System.in);

    public static String getString(String... field) {
        String tmp = "";
        if (field.length == 0) {
            do {
                if (!tmp.equals("")) {
                    System.out.println("Enter valid input");
                }
                sc.reset();
                tmp = sc.nextLine();
            } while (!tmp.matches("\\D*\\s*\\D"));
        } else {
            switch (field[0]) {
                case "ph":
                    do {
                        if (!tmp.equals("")) {
                            System.out.println("Enter valid phone number");
                        }
                        sc.reset();
                        tmp = sc.nextLine();
                    } while (!tmp.matches("\\d{10}"));
                    break;
                case "age":
                    do {
                        if (!tmp.equals("")) {
                            System.out.println("Enter valid phone number");
                        }
                        sc.reset();
                        tmp = sc.nextLine();
                    } while (!tmp.matches("\\d{2}\\d?"));
                    break;
                case "date":
                    boolean f = true;
                    do {
                        do {
                            if (!tmp.equals("")) {
                                System.out.println("Enter valid date");
                            }
                            sc.reset();
                            tmp = sc.nextLine();
                        } while (!tmp.matches("\\d{2}/\\d{2}/\\d{4}"));
                        try {
                            LocalDate.parse(tmp, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                            f = false;
                        } catch (Exception e) {
                            f = true;
                        }
                    } while (f);
                    break;
            }
        }
        return tmp;
    }

    public static String getFreeText() {
        return sc.nextLine();
    }

    public static int getInt() {
        int val = 0;
        do {
            try {
                sc.reset();
                val = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                val = 0;
            }
        } while (val == 0);
        return val;
    }

    public static String curnfutDate(String date) {
        if (LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy")).compareTo(LocalDate.now()) < 0) {
            System.out.println("Please enter current or future date");
            date=Utility.getString("date");
        }
        return date;
    }
}
