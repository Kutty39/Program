package com.blbz.deckofcards.utility;

public class MyQueue<T> extends OrderedList<T> {
       /*
Created by : Mr. Tamilselvan S
Created on : 15/11/2019
Purpose of Creating : To achieve the Q concept with the help of linked list
 */

    public void enQueue(T item, int rank) {
        add(item, rank);
    }//Adding the element

    //Deleting and returning the first element
    public T deQueus() {
        Node<T> tmp = head;

        if (isEmpty()) {
            return null;
        }

        head = head.next;
        setCount(getCount() - 1);
        return tmp.data;
    }

    //To check the Q has any value
    public boolean isEmpty() {
        return head == null;
    }
}
