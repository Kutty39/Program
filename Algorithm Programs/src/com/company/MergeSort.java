package com.company;

import java.util.Arrays;

public class MergeSort {

    public static String[] sorting(String[] a, String[] b) {
        String[] words = new String[a.length + b.length];
        int lnt = 0, iA = 0, iB = 0;

        while (lnt <= words.length-1) {
            if (a[iA].compareTo(b[iB]) < 0) {
                words[lnt] = a[iA];
                ++iA;
            } else {
                words[lnt] = b[iB];
                ++iB;
            }
            ++lnt;
            if (iB > b.length - 1) {
                for (int i = iA; i <a.length ; i++) {
                    words[lnt] = a[i];
                    ++lnt;
                }
            } else if (iA > a.length - 1) {
                for (int i = iB; i <b.length ; i++) {
                    words[lnt] = b[i];
                    ++lnt;
                }
            }
        }
        return words;
    }

    static String[] dividearray(String[] words) {
        String[] a, b;
        if (words.length > 1) {
            int mid = words.length / 2;
            a = dividearray(Arrays.copyOf(words, mid));
            b = dividearray(Arrays.copyOfRange(words, mid , words.length));
            return sorting(a, b);
        } else {
            return words;
        }
    }
}
