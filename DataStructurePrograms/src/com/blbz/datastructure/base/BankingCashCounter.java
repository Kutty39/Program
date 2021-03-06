package com.blbz.datastructure.base;

/*
Created by : Mr. Tamilselvan S
Created on : 15/11/2019
Purpose of Creating : to using List concept with the ordered linked list.
 */

import static com.blbz.datastructure.base.Utillity.*;

public class BankingCashCounter {
    MyQueue<Integer> q = new MyQueue<>();

    void peopleQ() {
        try {
            System.out.println("Please enter the Q length");
            sc.reset();
            int l = sc.nextInt();
            int total = 0;
            System.out.println("Enter the amount, if the people going to deposit money enter positive amount else negative amount");
            for (int i = 0; i < l; i++) {
                q.enQueue(sc.nextInt());
            }
            System.out.println(q.isEmpty());
            for (int i = 0; i < l; i++) {
                total = total + q.deQueus();
                System.out.println("Q length"+ q.size());
            }
            System.out.println(total);
        } catch (NullPointerException e) {
            System.out.println("Q is empty");
        }
    }
}
