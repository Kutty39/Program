package com.blbz.stockaccountnanagement.utility;

import java.util.Scanner;

public class Utility {
    Scanner sc = new Scanner(System.in);

    public String getInputString(String... s) {
        sc.reset();
        return sc.nextLine();
    }

    public int getInput() {
        int val = 0;
        sc.reset();
        try {
            val = Integer.parseInt(sc.nextLine());
            return val;
        } catch (Exception e) {
            System.out.println("Enter valid number");
            return getInput();
        }
    }

    public double getInputDouble() {
        double val = 0;
        sc.reset();
        try {
            val = Double.parseDouble(sc.nextLine());
            return val;
        } catch (Exception e) {
            System.out.println("Enter valid number");
            return getInputDouble();
        }
    }
}
//customized exception for lists
class PositionException extends Exception {
    @Override
    public String getMessage() {
        return "Given position is exited";
    }
}
//Node class
class Node<T> {
    T data = null;
    Node<T> next = null;
}

class MyQueue<T extends Comparable> extends UnOrderedList {
       /*
Created by : Mr. Tamilselvan S
Created on : 15/11/2019
Purpose of Creating : To achieve the Q concept with the help of linked list
 */


    void MyQueue() {
        new MyQueue<>();
    }//create instance

    void enQueue(T item) {
        add(item);
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


class Stock<T extends Comparable> extends UnOrderedList {
    /*
Created by : Mr. Tamilselvan S
Created on : 14/11/2019
Purpose of Creating : to using Stock concept with the linked list.
 */

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
        if (isEmpty()) {
            return null;
        } else {
            return (T) top.data;
        }
    }

}