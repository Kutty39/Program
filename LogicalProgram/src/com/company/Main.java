package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("1.Gambler\n2.Coupon Number\n3.Root finder\n4.WindChill\n5.Triplets\nSelect any option from the above:");
        Scanner in = new Scanner(System.in);
        in.reset();
        switch (in.nextLine()) {
            case "1":
                Gambler gm = new Gambler();
                break;
            case "2":
                CouponNumber cp = new CouponNumber();
                System.out.println(cp.distictcoupon(100));
                break;
            case "3":
                Stopwatch q = new Stopwatch();
                in.reset();
                System.out.println("Please enter 'S' to start");
                if (in.nextLine().toUpperCase().equals("S")) {
                    q.StartTime();
                    in.reset();
                    System.out.println("Please enter 'P' to start");
                    while (!in.nextLine().toUpperCase().equals("P")){
                        System.out.println("Please enter 'P' to start");
                        in.reset();
                    }
                    q.StopTime();
                }
                break;
            case "4":
                CrossGame wc =new CrossGame();

                break;
            /*case "5":
                Triplets tp=new Triplets();
                tp.tripletfinder();
                break;*/
            default:
                System.out.println("Bye Bye!!!!");
        }
    }
}
