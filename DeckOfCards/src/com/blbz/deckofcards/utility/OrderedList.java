package com.blbz.deckofcards.utility;

class Node<T> {
    T data = null;
    int rank = 0;
    Node<T> next = null;
}

public class OrderedList<T> {
    Node<T> head;
    private int count = 0;

    //Add an item in a list
    public void add(T item, int rank) {
        //temp value to track addition
        boolean added = false;
        //creating new node with data
        Node<T> n = new Node<>();
        n.data = item;
        n.rank = rank;
        n.next = null;

        //creating temp Node to store head
        Node<T> tmp = head, prvn = null;

        //looping through the Node to find last node or the Node which has greater value
        if (tmp == null) {
            head = n;
        } else {
            do {
                if (rank < tmp.rank) {//if 10 compare with 1 i will give negative value
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


    //Check whether the list is empty
    public boolean isEmpty() {
        /*by checking head is null we can tell list is empty or not.
        Or we can use getcount() function, if the count is 0 then it is empty
         */
        return head == null;
    }

    //Check the size
    public int size() {
        return getCount();
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}