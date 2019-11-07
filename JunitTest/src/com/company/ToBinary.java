package com.company;

public class ToBinary {
    static String ToBinary1() {
        int val = 24;
        StringBuilder sb = new StringBuilder();
        String byteval = "";
        while (val != 0) {
            int mod = val % 2;
            val = (val - mod) / 2;
            sb.append(mod);
        }
        return sb.reverse().toString();
    }
}
