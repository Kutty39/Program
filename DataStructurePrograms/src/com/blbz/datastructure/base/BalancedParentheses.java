package com.blbz.datastructure.base;

/*
Created by : Mr. Tamilselvan S
Created on : 14/11/2019
Purpose of Creating : to Check whether the given expression is having balance parentheses or not.
 */

public class BalancedParentheses {

    //This method will have the expression as input
    boolean balancedParentheses(String s){
        Stock<Character> sk=new Stock<>();//Creating new stock

        for (char c : s.toCharArray()) {//looping through the expression
            if (c == '(') {
                sk.push(c);//push the parentheses into stock
            } else if (c == ')') {
                sk.pop();//pop the parentheses out of stock
            }
        }
        return (sk.size() == 0);
    }
}
