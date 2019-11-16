package com.company;


/*
Created by : Mr. Tamilselvan S
Created on : 13/11/2019
Purpose of Creating : to serve this package with basic methods or tools.
 */


import java.io.*;
import java.util.Scanner;

public class Utillity {
    static Scanner sc = new Scanner(System.in);
    static BufferedReader listFile;

    public Utillity() {

    }

    //read text file
    public String[] readlistfile(String s) throws IOException {
        String[] tempstr = null;
        listFile = new BufferedReader(new FileReader(s));
        String tmp = listFile.readLine();
        while (tmp != null) {
            tempstr = tmp.split("\\s");
            tmp = listFile.readLine();
        }
        return tempstr;
    }

    //Write the list data into the file
    public void writeListData(Node head){
        try {
            FileWriter fr=new FileWriter("/home/admin1/Desktop/Tamilselvan/Program/DataStructurePrograms/src/com/company/outList.txt");
            PrintWriter pr=new PrintWriter(fr);
            Node n = head;
            if (head != null) {
                while (n.next != null) {
                    pr.println(n.data);
                    n = n.next;
                }
            } else {
                pr.println();
            }
            pr.close();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

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
            System.out.println("Empty");
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

class DequoNode<T> {
    DequoNode<T> prev, next;
    T data;

    DequoNode(T item) {
        this.prev = null;
        this.next = null;
        this.data = item;
    }

}

class Deque<T> {
    /*
Created by : Mr. Tamilselvan S
Created on : 14/11/2019
Purpose of Creating : Created to demonstrate Double linked list
 */

    //Introducing new node frond and rear
    DequoNode<T> front = null, head = null, rear = null;

    //check q is empty or not
    boolean isEmpty() {
        return head == null;
    }

    //Create new empty Deque
    void Deque() {
        new Deque<>();
    }

    //to add the variables in frond
    void addFront(T item) {
        DequoNode<T> n = new DequoNode<>(item);

        //whether the q is empty or not
        if (isEmpty()) {
            //insert element as first
            front = n;
            head = n;
            rear = n;
        } else {
            //insert element in front
            front.prev = n;
            n.next=front;
            front = n;
            head = n;
        }
    }

    //to add the variables in frond
    void addRear(T item) {
        DequoNode<T> n = new DequoNode<>(item);

        //whether the q is empty or not
        if (isEmpty()) {
            //insert element as first
            front = n;
            head = n;
            rear = n;
        } else {
            //insert element in front
            rear.next = n;
            n.prev=rear;
            rear = n;
        }
    }

    //Remove from frond
    T removeFrond() {
        T data;
        if (isEmpty()) {
            data= null;
        } else {
            data=front.data;
            front=front.next;
            head=front;
        }
        return data;
    }

    //Remove from rear
    T removeRear() {
        T data;
        if (isEmpty()) {
            data= null;
        } else {
            data=rear.data;
            rear=rear.prev;
        }
        return data;
    }

}