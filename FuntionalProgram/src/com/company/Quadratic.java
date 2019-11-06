package com.company;

public class Quadratic {
    public String rootfinder(int a, int b, int c) {
        Double delta =Math.pow(b,2) - (4*a*c);
        Double x1,x2;
        x1=(-b + Math.sqrt(delta))/(2*a);
        x2=(-b - Math.sqrt(delta))/(2*a);
        return "X1="+ x1 +",X2="+x2;
    }
}
