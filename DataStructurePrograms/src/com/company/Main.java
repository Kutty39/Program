package com.company;

import static com.company.Utillity.*;

public class Main {

    static boolean balancedParentheses(String s){
        Stock<Character> sk = new Stock<>();

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

    public static void main(String[] args) {
        sc.reset();//initiating Scanner
        //UnOrderedList<String> list = new UnOrderedList<>();//initiating list class
        //OrderedList<Integer> ordlist = new OrderedList<>();//initiating Ordered list class
       System.out.println( balancedParentheses("((5+6)∗(7+8))/(4+3)(5+6)∗(7+8)/(4+3)"));
    }
}
