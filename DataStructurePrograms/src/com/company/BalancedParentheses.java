package com.company;



public class BalancedParentheses {
    boolean balancedParentheses(String s){
        Stock<Character> sk=new Stock<>();

        for (char c : s.toCharArray()) {
            if (c == '(') {
                sk.push(c);
            } else if (c == ')') {
                sk.pop();
            }
            //System.out.println(sk.peek()==null?"":sk.peek());
        }
        if (sk.size() == 0) {
            System.out.println();
        }
        return (sk.size() == 0);
    }
}
