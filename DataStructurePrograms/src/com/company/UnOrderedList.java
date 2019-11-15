package com.company;
/*
Created by : Mr. Tamilselvan S
Created on : 13/11/2019
Purpose of Creating : to using List concept with the linked list.
 */

public class UnOrderedList<T> {
    //Declaration and initialization
    Node<T> head;

    private int count;

    //Initializing list
    void list() {
        new UnOrderedList();
    }

    //Adding data to list
    void append(T item) {
        add(item);
    }

    //Adding data to list
    void add(T item) {
        Node<T> n = new Node<>();
        n.data = item;
        n.next = null;

        if (isEmpty()) {
            head = n;
        } else {

            //Checking for tha last Node to add data
            Node<T> tmp = head;
            while (tmp.next != null) {//Looping with all the available Node
                tmp = tmp.next;
            }
            tmp.next = n;

        }
        setCount(getCount() + 1);//increase the list count
    }

    //To add the element using position
    void insert(int pos, T item) throws PositionException {

        //initializing two temp Node.
        Node<T> crntn;
        Node<T> prvn;

        //get current index of the list
        int indx = getCount();

        //Throwing error if the position is exited the list length
        if (indx < pos) {
            throw new PositionException();
        }

        int i = 0;//index for looping

        //Initializing the Node with given data
        Node<T> n = new Node<>();
        n.data = item;

        //initialize the Nodes for the looping
        prvn = null;
        crntn = head;

        //Checking the index matching with pos
        while (i != pos) {
            prvn = crntn;//always current Node is the Previous Node for next iteration
            crntn = crntn.next;//Next Node of the current Node is current Node for next iteration
            ++i;
        }

        //check whether the position is lies first of in between
        if (prvn == null) {
            //if the position lies first we have to assign the new Node as head
            n.next = crntn;
            head = n;
        } else {
            //if it is in between, connect the new Node to previous and next Node
            prvn.next = n;
            n.next = crntn;
        }

}

    //To get size of a list
    int size() {
        return getCount();
    }

    //check whether the list is empty or not.
    boolean isEmpty() {
        return head == null;
    }

    //this will search an item in a list
    boolean search(T item) {
        Node<T> tmp = head;
        if (tmp.data == item) {
            return true;
        } else {
            do {//looping with all the Node
                tmp = tmp.next;
                if (tmp.data == item) {
                    return true;
                }
            } while (tmp.next != null);
        }
        return false;
    }

    //To get the index a Data
    int index(T item) {
        Node<T> tmp = head;
        int i = 0;
        do {
            if (tmp.data == item) {
                return i;
            }
            tmp = tmp.next;
            ++i;
        } while (tmp.data != null);
        return 0;
    }

    //take the last value out and remove the last Node itself
    T pop() {
        Node<T> n = head;
        Node<T> prvn = null;
        T val = null;
        while (n.next != null) {
            prvn = n;
            n = n.next;
        }
        prvn.next = null;
        val = (T) n.data;
        setCount(getCount() - 1);

        return val;
    }

    //Remove the node which have the item data
    void remove(T item) {
        Node<T> n = head;
        Node<T> prvn, nextn;
        prvn = head;

        do {//Checking the data is matching with any Node or not
            nextn = n.next;
            if (n.data == item) {
                break;
            }
            prvn = n;
            n = n.next;
        } while (n.next != null);

        if (n.data == item) {//unlink/Delete the Node with has item data.
            if (head == prvn) {
                head = head.next;

            } else {
                prvn.next = nextn;
            }
            setCount(getCount() - 1);//Decrease the list count
        }
    }

    //Remove the node which have the item data
    T pop(int pos) {
        int i = 0;//for indexing

        //initiating temp Node as head
        Node<T> tmp = head;
        Node<T> prvn = null, nextn = null;//to store previous Node and next Node of the matching Node

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

    //Method to increase list count
    int getCount() {
        return count;
    }

    //Method to decrease list count
    void setCount(int count) {
        this.count = count;
    }

    //Search using the data and remove if it is present or insert if it is not.
    T searchAdd(T s) {
        if (search(s)) {
            remove(s);
            return (T) "Found and Removed";
        } else {
            add(s);
            return (T) "Not Found and Added";
        }
    }
}