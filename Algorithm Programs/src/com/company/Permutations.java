package com.company;

public class Permutations {
    static int k = 0, lth = 0;
    //static String tmp = "";
    static String[] outstr;

    public static void main(String[] args) {
        lth = 3;
        String s="ABCD";
        outstr = new String[lenOfArry(s.length())];
        swap(s, 0);
        System.out.println(outstr.toString());
    }

    private static int lenOfArry(int ln) {
        if (ln == 1) {
            return 1;
        } else {
            return ln*lenOfArry(ln-1);
        }
    }

    private static void swap(String s, int from) {
        if (from == s.length()) {
            outstr[k] = s;
            ++k;
        } else {
            for (int i = from; i < s.length(); i++) {
                char[] ch = s.toCharArray();
                char tmp = ch[from];
                ch[from] = ch[i];
                ch[i] = tmp;
                swap(String.valueOf(ch), from + 1);
            }
        }
    }

}