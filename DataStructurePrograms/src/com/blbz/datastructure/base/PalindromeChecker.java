package com.blbz.datastructure.base;

/*
Created by : Mr. Tamilselvan S
Created on : 16/11/2019
Purpose of Creating : by implementing double linked list to solve palindrome problem
 */
public class PalindromeChecker {

    //Method to return revers order string with the help of double linked list
    static String  check(String s) {
        Deque<Character> dq=new Deque<>();//initiating doublelinked lists
        char[] ch = s.toCharArray();//converting input string to char array to process the data
        for (char c : ch) {//loop for adding the char in to double linked list
            dq.addRear(c);
        }
        DequoNode temp=dq.rear;//getting the rear side of a double linked list to print the data
        s="";
        for (int i = 0; i <ch.length ; i++) {
            s=s+temp.data;
            temp=temp.prev;
        }
        return s;
    }
}
