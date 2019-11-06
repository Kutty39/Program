package com.company;

public class Quadratic {
    public static String rootfinder(int a, int b, int c) {
        double delta = Math.pow(b, 2) - (4 * a * c);
        double x1 = (-b + Math.sqrt(delta)) / (2 * a);
        double x2 = (-b - Math.sqrt(delta)) / (2 * a);
        return "X1="+ x1 +",X2="+x2;
    }
}
