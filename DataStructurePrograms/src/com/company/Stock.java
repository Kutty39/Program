package com.company;
/*
Created by : Mr. Tamilselvan S
Created on : 14/11/2019
Purpose of Creating : to using Stock concept with the linked list.
 */

public class Stock<T> extends UnOrderedList {
    private Node<T> top;

    void stack() {
        new Stock();
    }

    void push(T item) {
        Node<T> n = new Node<>();

        n.data = item;

        top = n;//assign the new Node as Top
        add(item);//adding Node to the Stock
    }

    //Pop the final element
    @Override
    T pop() {
        if (isEmpty()) {
            return null;
        } else {
            //temp and Previous Node
            Node<T> prvn = null;
            Node<T> tmp = head;

            if (tmp != null) {
                while (tmp.next != null) {
                    prvn = tmp;
                    tmp = tmp.next;
                }
            }

            //if the previous Node is null which means we are in the head Node
            if (prvn != null) {
                prvn.next = null;
                top = prvn;
            } else {
                head = prvn;
                top = head;
            }
            setCount(getCount() - 1);//reduce the stock size
            return tmp.data;
        }
    }

    T peek() {
        if(isEmpty()){
            return null;
        }else{
            return (T) top.data;
        }
    }

}
