package com.blbz.base;


public class ToBinary {
    private static StringBuilder sb;
    public static void main(String[] args) {
        System.out.println(IntToBinary(26));
        System.out.println(Binarytoint(IntToBinary(26)));
    }

    private static String IntToBinary(int val) {
        sb = new StringBuilder();
        while (val != 0) {
            int mod = val % 2;
            val = (val - mod) / 2;
            sb.append(mod);
        }
        if (sb.length() % 4 != 0) {
            int adval = sb.length() % 4;
            sb.append("0".repeat(4 - adval));
        }
        return sb.reverse().toString();
    }

    private static double Binarytoint(String byval) {
        double tmpint = 0.0;
        int j = byval.length()-1;
        char[] k= byval.toCharArray();
        sb= new StringBuilder();
        for (int i = 0; i < k.length/4 ; i++) {
            sb = new StringBuilder(""+  String.valueOf(k, i * 4, 4)+sb);
        }
        byval = sb.toString();
        k= byval.toCharArray();
        for (char i :k) {
            tmpint = tmpint + (Character.getNumericValue(i)* Math.pow(2, j));
            --j;
        }
        return tmpint;
    }
}
