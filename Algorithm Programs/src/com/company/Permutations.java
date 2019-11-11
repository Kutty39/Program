package com.company;

public class Permutations {
    static int k = 0;
    //static String tmp = "";
    private static String[] outstr;

    public Permutations(String s) {
        outstr = new String[lenOfArry(s.length())];
        recursion(s, 0);
        //itration(s);
        System.out.println(outstr.toString());
    }

   /* private static String swap(String sj, int from) {
        StringBuilder sb = new StringBuilder(sj);
        char c = sb.charAt(from);
        sb.deleteCharAt(from);
        sb.append(c);
        return String.valueOf(sb);
    }*/

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
            System.out.println(s);
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