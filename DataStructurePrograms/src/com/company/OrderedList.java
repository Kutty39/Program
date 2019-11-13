package com.company;

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
                if (item.compareTo(tmp.data) <= 0) {//if 10 compare with 1 i will give positive value
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
                prvn=tmp;
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

    void remove(T item) {
        Node tmp = null, prvn = null, nextn = null;
        tmp = head;
        do {
            nextn = tmp.next;
            if (tmp.data == item) {
                break;
            }
            tmp = nextn;
        } while (tmp != null);
        if (prvn != null) {
            prvn.next = nextn;
        } else {
            head = nextn;
        }
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
