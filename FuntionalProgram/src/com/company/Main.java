package com.company;

import com.arry.Arry;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("1.2D Array\n2.Distance\n3.Root finder\nSelect any option from the above:");
        Scanner in = new Scanner(System.in);
        in.reset();
        switch (in.nextLine()) {
            case "1":
                Arry ar = new Arry();
                ar.PrintArray( ar.createArry());
                break;
            case "2":
                Distance dt = new Distance();
                System.out.println(dt.Euclidean(5, 6));
                break;
            case "3":
                Quadratic q =new Quadratic();
                System.out.println(q.rootfinder(5,6,8));
                break;
            default:
                System.out.println("Bye Bye!!!!");
        }
    }
}

