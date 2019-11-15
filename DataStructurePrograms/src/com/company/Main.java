package com.company;

import static com.company.Utillity.*;

public class Main {

    public static void main(String[] args) {
        sc.reset();//initiating Scanner
        //UnOrderedList<String> list = new UnOrderedList<>();//initiating list class
        //OrderedList<Integer> ordlist = new OrderedList<>();//initiating Ordered list class
        BankingCashCounter bp=new BankingCashCounter();
        bp.peopleQ();
    }
}
