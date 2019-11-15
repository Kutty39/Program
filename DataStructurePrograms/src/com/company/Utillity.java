package com.company;


/*
Created by : Mr. Tamilselvan S
Created on : 13/11/2019
Purpose of Creating : to serve this package with basic methods or tools.
 */


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Utillity {
    static Scanner sc = new Scanner(System.in);
    static BufferedReader listFile;

    public Utillity() {

    }

    //read text file
    static String[] readlistfile() throws IOException {
        String[] tempstr = null;
        listFile = new BufferedReader(new FileReader("/home/admin1/Desktop/Tamilselvan/Program/DataStructurePrograms/src/com/company/intval.txt"));
        String tmp = listFile.readLine();
        while (tmp != null) {
            tempstr = tmp.split("\\s");
            tmp = listFile.readLine();
        }
        return tempstr;
    }

    //To Print the data
    static void printlist(Node head) {
        Node n = head;
        if (head != null) {
            while (n.next != null) {
                System.out.println(n.data);
                n = n.next;
            }
            System.out.println(n.data != null ? n.data : "");
        } else {
            System.out.println("List is Empty");
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

class MyQueue<T> extends UnOrderedList {

    void MyQueue() {
        new MyQueue<>();
    }

    void enQueue(T item) {
        add(item);
    }

    T deQueus() {
        Node<T> tmp = head;

        if (isEmpty()) {
            return null;
        }

        head = head.next;
        setCount(getCount() - 1);
        return tmp.data;
    }

    boolean isEmpty() {
        return head == null;
    }
}


class Stock<T> extends UnOrderedList {
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
