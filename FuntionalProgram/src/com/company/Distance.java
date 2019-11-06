package com.company;

import static java.lang.Math.pow;

public class Distance {

    public static double Euclidean(int x, int y) {
        return Math.sqrt(pow(x, 2) + pow(y, 2));
    }
}
