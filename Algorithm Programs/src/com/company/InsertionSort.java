package com.company;


public class InsertionSort<T extends Comparable> {
    public T[] sorting(T[] s) {
        for (int i = 0; i < s.length; i++) {
            int j = i - 1;
            int k = i;
            while (j >= 0) {
                if (s[j].compareTo(s[k]) > 0) {
                    T tmp = s[j];
                    s[j] = s[k];
                    s[k] = tmp;
                } else {
                    break;
                }
                --j;
                --k;
            }
        }
        return s;
    }
}
