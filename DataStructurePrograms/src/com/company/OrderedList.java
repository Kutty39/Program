package com.company;

/*
Created by : Mr. Tamilselvan S
Created on : 13/11/2019
Purpose of Creating : to using List concept with the ordered linked list.
 */



public class OrderedList<T extends Comparable> {
    Node head;
    private int count = 0;

    //just creating new ordered list.
    void OrderedList() {
        new OrderedList();
    }

    //Add an item in a list
    void add(T item) {
        //temp value to track addition
        boolean added = false;
        //creating new node with data
        Node n = new Node();
        n.data = item;
        n.next = null;

        //creating temp Node to store head
        Node tmp = head, prvn = null;

        //looping through the Node to find last node or the Node which has greater value
        if (tmp == null) {
            head = n;
        } else {
            do {
                if (item.compareTo(tmp.data) <= 0) {//if 10 compare with 1 i will give negative value
                    if (prvn != null) {
                        prvn.next = n;
                        n.next = tmp;
                    } else {
                        n.next = head;
                        head = n;
                    }
                    added = true;
                    break;
                }
                prvn = tmp;
                tmp = tmp.next;
            } while (tmp != null);
        }
        if (!added) {
            if (prvn != null) {
                prvn.next = n;
            } else {
                head = n;
            }
        }
        setCount(getCount() + 1);//increasing the list count

    }

    //To remove
    void remove(T item) {
        //initializing
        Node tmp = null, prvn = null, nextn = null;
        tmp = head;

        //looping through Nodes
        do {
            nextn = tmp.next;
            if (tmp.data == item) {
                break;
            }
            tmp = nextn;
        } while (tmp != null);

        //Removing the Node by replacing its next value and if it is a head by assigning next Nodes of head as head, we can remove head
        if (prvn != null) {
            prvn.next = nextn;
            setCount(getCount() - 1);
        } else {
            head = nextn;
            setCount(getCount() - 1);
        }
    }

    //to search
    boolean search(T item) {
        Node tmp = head;
        //looping through Nodes
        do {
            if (tmp.data == item) {
                return true;
            }
            tmp = tmp.next;
        } while (tmp != null);
        return false;
    }

    //Check whether the list is empty
    boolean isEmpty() {
        /*by checking head is null we can tell list is empty or not.
        Or we can use getcount() function, if the count is 0 then it is empty
         */
        return head == null;
    }

    //Check the size
    int size() {
        return getCount();
    }

    //getting index of a Node
    int index(T item) {
        int i = 0;//temp int for count
        Node tmp = head;

        //looping through Nodes
        do {
            if (tmp.data == item) {
                return i;
            }
            ++i;
            tmp = tmp.next;
        } while (tmp != null);
        return -1;//if the item not found it will return -1
    }

    //pop the Node
    T pop() {
        //initiating temp Node as head
        Node tmp = head;
        Node prvn = null;//to store previous Node of the last Node

        while (tmp.next != null) {
            prvn = tmp;
            tmp = tmp.next;
        }
        //Check whether the first Node is last Node
        if (prvn != null) {
            prvn.next = null;
        } else {
            head = null;
        }
        setCount(getCount() - 1);//decreasing list count
        return (T) tmp.data;
    }


    //pop the Node
    T pop(int pos) {
        int i = 0;//for indexing

        //initiating temp Node as head
        Node tmp = head;
        Node prvn = null, nextn = null;//to store previous Node and next Node of the matching Node

        nextn = tmp.next;//next Node

        //looping until the last Node.next
        do {
            if (i < getCount()) {
                if (i == pos) {
                    break;
                }
                prvn = tmp;//current Node is previous Node
                tmp = nextn;//next Node is current node
                nextn = tmp.next;
                ++i;
            } else {
                return null;
            }
        } while (tmp != null);


        //Check whether the first Node is last Node
        if (prvn != null) {
            prvn.next = nextn;
        } else {
            head = nextn;
        }
        setCount(getCount() - 1);//decreasing list count
        return (T) tmp.data;
    }


    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
