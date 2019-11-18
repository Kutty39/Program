package com.company;

import java.util.Arrays;

public class PrimeNumbers {
    public static int[] find(int from, int to) {
        int[] tempint = new int[to];
        int prmcount = 0;
        boolean primeflag = true;
        for (int i = from; i < to; i++) {
            primeflag = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    primeflag = false;
                    break;
                }
            }
            if (primeflag) {
                tempint[prmcount] = i;
                ++prmcount;
            }
        }
        return Arrays.copyOf(tempint, prmcount);
    }

    public static int[] pallindromeint(int[] i) {
        int[] temp = new int[i.length];
        int count = 0;
        for (int item : i) {
            StringBuilder sb = new StringBuilder("" + item);
            sb.reverse();
            if (sb.length() > 1) {
                if (String.valueOf(item).equals(sb.toString())) {
                    temp[count] = item;
                    ++count;
                }
            }
        }
        return Arrays.copyOf(temp, count);
    }

    public static int[] anagramint(int[] i) {
        int[] tempint = new int[i.length];
        int count = 0;
        boolean flagpermu = false;
        for (int item : i) {
            StringBuilder sb = new StringBuilder("" + item);
            flagpermu = false;
            if (sb.length() > 1) {
                String[] permu = Permutations.findPermutations(sb.toString());
                Arrays.sort(permu);
                for (String s : permu) {
                    for (int val : i) {
                        if (val != item) {
                            flagpermu = s.equals(String.valueOf(val));
                            if (flagpermu || Integer.parseInt(s) < val) {
                                break;
                            }
                        }
                    }
                    if (flagpermu) {
                        tempint[count] = item;
                        ++count;
                        break;
                    }
                }
            }
        }
        return Arrays.copyOf(tempint, count);
    }
}
