package com.company;

import java.util.Random;
import java.util.Scanner;
import java.lang.Math;

public class Main {
    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        // write your code here
        System.out.println("1.Name Printing\n 2.Flip a coin\n 3.Leap year\n 4.Power of 2\n 5.Harmonic Number\n 6.Factors\n What program you want to run, pleas enter the number of the program :");
        in.reset();
        in = new Scanner(System.in);
        switch (in.nextInt()) {
            case 1:
                NamePrint();
                break;
            case 2:
                FlipAcoin();
                break;
            case 3:
                LeapYear();
                break;
            case 4:
                PowerOf2();
                break;
            case 5:
                HarmonicNumber();
                break;
            case 6:
                PrimeFactors();
                break;
            default:
                System.out.println("input does not match with a expected input");
                break;

        }
    }

    private static void PrimeFactors() {
        String tmp = "";
        boolean prmflag = true;
        int it = 0, pm = 0, i = 0;
        while (!(tmp.toUpperCase().equals("Q"))) {
            pm = 0;
            i = 2;
            System.out.print("Please enter any number(not 'Zero') :");
            in.reset();
            in = new Scanner(System.in);
            tmp = in.nextLine();
            if (tmp.toUpperCase().equals("Q")) {
                break;
            }

            if (isint(tmp)) {
                it = Integer.parseInt(tmp);
                System.out.print("Prime factor for " + it + " is ");
                for (int j = 2; j * j <= it; j++) {
                    prmflag = true;
                    for (int k = 2; k < j; k++) {
                        if (j % k == 0) {
                            prmflag = false;
                            break;
                        }
                    }
                    if (prmflag) {
                        while (it % j == 0) {
                            it = it / j;
                            System.out.print(j + "*");
                        }
                    }
                }
                System.out.println(it);
            }
        }
    }

    private static void HarmonicNumber() {
        String tmp = "";
        float hm;
        int it = 0;
        while (!(tmp.toUpperCase().equals("Q"))) {
            hm = 0;
            System.out.print("Please enter any number(not 'Zero') :");
            in.reset();
            in = new Scanner(System.in);
            tmp = in.nextLine();
            if (tmp.toUpperCase().equals("Q")) {
                break;
            }

            if (isint(tmp)) {
                it = Integer.parseInt(tmp);
                if (it != 0) {
                    for (float i = 1; i <= it; i++) {
                        hm = hm + (1 / i);
                    }
                    System.out.println("Harmonic value is " + String.format("%.2f", hm));
                }
            }
        }
    }

    private static void PowerOf2() {
        String tmp = "";
        int sq = 0;
        while (!(tmp.toUpperCase().equals("Q"))) {
            System.out.print("Please enter any number(not more than 31) :");
            in.reset();
            in = new Scanner(System.in);
            tmp = in.nextLine();
            if (tmp.toUpperCase().equals("Q")) {
                break;
            }

            if (isint(tmp)) {
                sq = Integer.parseInt(tmp);
                if (sq <= 31) {
                    for (int i = 0; i <= sq; i++) {
                        System.out.println("2^" + i + " = " + String.format("%.2f", Math.pow(2, i)));
                    }
                }
            } else {
                System.out.println("Please enter valid number");
            }

        }

    }

    private static void LeapYear() {
        int yr = 0;
        float div4, div400, div100;
        String lp, tmp = "";
        while (!(tmp.toUpperCase().equals("Q"))) {
            lp = "";
            System.out.print("Please enter any year :");
            in.reset();
            in = new Scanner(System.in);
            tmp = in.nextLine();
            if (tmp.toUpperCase().equals("Q")) {
                break;
            }
            if (isint(tmp)) {
                if (tmp.length() == 4) {
                    yr = Integer.parseInt(tmp);
                    div4 = yr % 4;
                    div100 = yr % 100;
                    div400 = yr % 400;
                    if (div100 == 0) {
                        if (div400 != 0) {
                            lp = "not a ";
                        }
                    } else {
                        if (div4 != 0) {
                            lp = "not a ";
                        }
                    }
                    System.out.println(tmp + " is {}leap year".replace("{}", lp));
                } else {
                    System.out.println("Please enter valid year");
                }
            } else {
                System.out.println("Please enter valid year");
            }
        }
    }


    private static void FlipAcoin() {
        Integer tm, side;
        Double hd, tl;
        String tmp = "";
        while (!(tmp.toUpperCase().equals("Q"))) {
            hd = 0.0;
            tl = 0.0;
            System.out.print("How many times you want to flip a coin : ");
            in.reset();
            in = new Scanner(System.in);
            tmp = in.nextLine();
            if (tmp.toUpperCase().equals("Q")) {
                break;
            }
            if (isint(tmp)) {
                tm = Integer.parseInt(tmp);
                Random rnd = new Random();
                side = rnd.nextInt(1);
                for (int i = 0; i < tm; i++) {
                    if (rnd.nextFloat() > 0.5) {
                        hd += 1.0;
                    } else {
                        tl += 1.0;
                    }
                }
                System.out.println("Head % :" + String.format("%.2f", hd / tm * 100));
                System.out.println("Tail % :" + String.format("%.2f", tl / tm * 100));
            }
        }

    }

    private static boolean isint(String nextLine) {
        try {
            int i = Integer.parseInt(nextLine);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static void NamePrint() {
        String inval = "";
        do {
            System.out.print("Enter the name :");
            in.reset();
            in = new Scanner(System.in);
            inval = in.nextLine();
            if (inval.toUpperCase().equals("Q")) {
                System.out.println("Bye Bye!!1");
                break;
            } else ;
            {
                System.out.println("Hello <<UserName>>, How are you?".replace("<<UserName>>", inval));
            }
        } while (!inval.toUpperCase().equals("Q"));
    }
}
