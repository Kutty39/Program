package com.blbz.deckofcards.utility;

public class MyQueue<T extends Comparable> extends OrderedList {
       /*
Created by : Mr. Tamilselvan S
Created on : 15/11/2019
Purpose of Creating : To achieve the Q concept with the help of linked list
 */


    void MyQueue() {
        new MyQueue<>();
    }//create instance

    void enQueue(T item,T rank) {
        add(item,rank);
    }//Adding the element

    //Deleting and returning the last element
    T deQueus() {
        Node<T> tmp = head;

        if (isEmpty()) {
            return null;
        }

        head = head.next;
        setCount(getCount() - 1);
        return tmp.data;
    }

    //To check the Q has any value
    boolean isEmpty() {
        return head == null;
    }
}
