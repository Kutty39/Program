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
                Stopwatch q =new Stopwatch();
                q.StartTime();
                break;
            /*case "4":
                WindChill wc =new WindChill();
                System.out.println(wc.chill(26,60));
                break;
            case "5":
                Triplets tp=new Triplets();
                tp.tripletfinder();
                break;*/
            default:
                System.out.println("Bye Bye!!!!");
        }
    }
}
