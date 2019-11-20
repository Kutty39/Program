package com.blbz.algorithm.base;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Permutations {
    static int k = 0;
    //static String tmp = "";
    private static String[] outstr;

    public static String[] findPermutations(String s) {
        outstr = new String[lenOfArry(s.length())];
        recursion(s, 0);
        k=0;
        Arrays.sort(outstr);
        return outstr;
    }
    private static int lenOfArry(int ln) {
        if (ln == 1) {
            return 1;
        } else {
            return ln * lenOfArry(ln - 1);
        }
    }

    private static void recursion(String s, int from) {
        if (from == s.length()) {
            outstr[k] = s;
            ++k;
        } else {
            for (int i = from; i < s.length(); i++) {
                char[] ch = s.toCharArray();
                char tmp = ch[from];
                ch[from] = ch[i];
                ch[i] = tmp;
                recursion(String.valueOf(ch), from + 1);
            }
        }
    }

}