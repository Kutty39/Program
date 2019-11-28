package com.blbz.deckofcards.utility;

public class OrderedList<T extends Comparable> {
    Node head;
    private int count = 0;

    //Add an item in a list
    void add(T item,T rank) {
        //temp value to track addition
        boolean added = false;
        //creating new node with data
        Node n = new Node();
        n.data = item;
        n.rank=rank;
        n.next = null;

        //creating temp Node to store head
        Node tmp = head, prvn = null;

        //looping through the Node to find last node or the Node which has greater value
        if (tmp == null) {
            head = n;
        } else {
            do {
                if (rank.compareTo(tmp.rank) <= 0) {//if 10 compare with 1 i will give negative value
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


    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}