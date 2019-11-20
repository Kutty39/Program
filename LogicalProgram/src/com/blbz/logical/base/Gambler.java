package com.blbz.logical.base;

import java.util.Random;
import java.util.Scanner;

public class Gambler {
    private static double game = 0, win = 0, loss = 0;

    public Gambler() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter $Stake:");
        sc.reset();
        int stk = sc.nextInt();
        System.out.println("Please enter $Goal:");
        sc.reset();
        int goal = sc.nextInt();
        while (stk < goal && stk != 0) {
            Random random = new Random();
            float tmp = random.nextFloat();
            if (tmp > 0.5) {
                ++win;
                ++stk;
            } else {
                ++loss;
                --stk;
            }
            ++game;
        }
        if (stk != 0) {
            System.out.println("Hurray!!! you have achieved your goal!!!");
        } else {
            System.out.println("Sorry you lost all your money");
        }
        System.out.println("\nGame Statistics:\n\n1.Number of games played :" + game);
        System.out.println("2.No. games you won and % :" + win + "," + String.format("%.2f", win / game*100));
        System.out.println("3.No. of game you lost and %:" + loss + "," + String.format("%.2f", loss / game*100));
        System.out.println("4.Amount you have in your hand:" + stk);
    }
}
