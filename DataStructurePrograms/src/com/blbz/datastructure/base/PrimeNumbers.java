package com.blbz.datastructure.base;

/*
Created by : Mr. Tamilselvan S
Created on : 18/11/2019
Purpose of Creating :Take a range of 0 - 1000 Numbers and find the Prime numbers in that range.
                     Store the prime numbers in a 2D Array, the first dimension represents the range 0-100, 100-200, and so on.
                     While the second dimension represents the prime numbers in that range
 */


import java.util.Arrays;

public class PrimeNumbers {
    //Array for anagram and Not anagram
    static String[][] anagram;
    static String[][] notanagram;

    //Method to find palindrome
    public static String[][] find(int from, int to) {
        //variable declaration
        String[][] tempString = new String[to][2];//temp array to store value
        int prmcount = 0;//this will help us to store value in appropriate location in the temp array.
        int rangestart = 0, rangeend = 100;//deciding range
        boolean primeflag = true;//to check prime

        //looping the data
        for (int i = from; i < to; i++) {
            primeflag = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {//Block to check whether the number is divisible with out reminders
                    primeflag = false;
                    break;
                }
            }
            if (primeflag) {//if the number is not divisible by any number other than itself. this flag is true.
                /*checking the range is changed or not.
                if it is changed. we should change the range start as previous range end.
                range end - incrementing by 100
                 */
                if (rangeend < i) {
                    rangestart = rangeend;
                    rangeend = rangeend + 100;
                }

                //value assignment into the array
                tempString[prmcount][0] = rangestart + "-" + rangeend;
                tempString[prmcount][1] = "" + i;
                ++prmcount;
            }
        }
        return Arrays.copyOf(tempString, prmcount);
    }

    //Method to check anagram
    public static String[][] anagram(String[][] primnumber) {
        String[][] temp = new String[primnumber.length][2];
        notanagram = new String[primnumber.length][2];
        anagram = new String[primnumber.length][2];
        String[] ordstring = new String[primnumber.length];//to store sorted value
        int pos = 0, pos1 = 0;//starting position for the ordered string
        String[] permarr;//to store permutations

        /* check with sorted string to identify anagram.
        eg, 21 is sorted as 12, in this loop we will check 12 with sored 21 which is 12
        to check like this we have to sort the original string too like \
        if we are going to check 21 as anagram we should sort 21 as 12.
         */
        boolean primflag = false;
        for (String[] palnum : primnumber) {
            permarr = Permutations.findPermutations(palnum[1]);
            if (palnum[1].length() > 1) {
                for (String pr : permarr) {
                    for (String[] s : primnumber) {
                        if (!s[1].equals(palnum[1])) {
                            primflag = s[1].equals(pr);
                            if (primflag) {
                                break;
                            }
                        }
                    }
                    if (primflag) {
                        anagram[pos][0] = palnum[0];
                        anagram[pos][1] = palnum[1];
                        ++pos;
                        break;
                    }
                }
                if (!primflag) {
                    notanagram[pos1][0] = palnum[0];
                    notanagram[pos1][1] = palnum[1];
                    ++pos1;
                } else {
                    primflag = false;
                }
            }
        }
        anagram = Arrays.copyOf(anagram, pos);
        notanagram = Arrays.copyOf(notanagram, pos1);
        return Arrays.copyOf(anagram, pos);
    }

    static void anagramstackprint(String[][] anagram){
        Stock<String> stk=new Stock<>();
        for (String [] s:anagram) {
            stk.push(s[1]);
        }
        int j=stk.size();
        for (int i = 0; i <j ; i++) {
            System.out.println(stk.pop());
        }
    }

    static void anagramqueue(){
        MyQueue<String> q=new MyQueue<>();
        for (String [] s:anagram) {
            q.enQueue(s[1]);
        }
        int j=q.size();
        for (int i = 0; i <j ; i++) {
            System.out.println(q.deQueus());
        }
    }

    static void print2darray(String[][] str) {
        String temp = "";
        temp = "{";
        for (String[] s : str) {
            temp = temp + "{" + s[0] + "," + s[1] + "},";
        }
        if (!temp.equals("{")) {
            temp = temp.substring(0, temp.length() - 1);
        }
        temp = temp + "}";
        System.out.println(temp);
    }

    public static void main(String[] args) {
        System.out.println("Prime number with range:");
        print2darray(find(0, 1000));
        System.out.println("Anagram in Prime number:");
        print2darray(anagram(find(0, 1000)));
        System.out.println("Stack with anagram:");
        anagramstackprint(anagram);
        System.out.println("Queue with anagram:");
        anagramqueue();
    }
}
