package com.company;

import com.sun.source.tree.ReturnTree;

import java.util.Scanner;

public  class FindYourNumber {
    static void binarySearch(int val) {
        int low, high, mid,searchnum,count;
        int[] totnum = new int[val];
        for (int i = 0; i < val; i++) {
            totnum[i] = i ;
        }

        System.out.println("Please think of a number between 0 - "+ (val-1));

        low = 0;
        high = val;
        count=0;
        while (low <= high) {
            mid=(low + high) / 2;
            searchnum=totnum[mid];
            int userinput=check(searchnum,++count,low+1,mid-1);
            if(userinput == 1){
                high=mid-1;
            }else if(userinput==0){
                low=mid+1;
            }else {
                break;
            }
        }
    }

    static int check(int num, int count, int from, int to) {
        Scanner sc = new Scanner(System.in);
        System.out.println("The number is " + num + ". if it is correct enter 1 or enter 0");
        try {
            if (sc.nextInt() == 1) {
                System.out.println("I found it :)\nIntermediary number is " + count + "\nFinal number is " + num);
                return -1;
            } else {
                System.out.println("Oh no!!\n\n your number is between " + from + " to " + to + ".\n enter 1 for yes or enter 0 for no");
                sc.reset();
                return sc.nextInt();
            }
        } catch (Exception e) {
            System.out.println("Please enter number only!!");
            return -1;
        }


    }
}
