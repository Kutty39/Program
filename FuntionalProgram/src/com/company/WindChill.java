package com.company;

public class WindChill {
    public static double chill(double tmp,double vlos){
        return  (35.74+0.6215*tmp+(0.4275*tmp-35.75)*Math.pow(vlos,0.16));
    }
}
