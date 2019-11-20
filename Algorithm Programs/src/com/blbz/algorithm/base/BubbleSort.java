package com.blbz.algorithm.base;

public class BubbleSort {
    public static int[] bubbleSorting(int[] i){
        int lenth =i.length;
        int cmparval=0;
        while (lenth!=0) {
            cmparval=0;
            for (int j = 0; j < lenth-1; j++) {
                if(i[j]>i[++cmparval]){
                    int tmp= i[j];
                    i[j]=i[cmparval];
                    i[cmparval]=tmp;
                }
            }
            --lenth;
        }
        return i;
    }
}
