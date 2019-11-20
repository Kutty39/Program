package com.blbz.datastructure.base;


/*
Created by : Mr. Tamilselvan S
Created on : 13/11/2019
Purpose of Creating : to serve this package with basic methods or tools.
 */

import java.util.HashMap;

public class HashingFunction {
    //creating Hash map variable
    HashMap<Integer, OrderedList<Integer>> map = new HashMap<Integer, OrderedList<Integer>>();

    //Method to add the key and value(list)
    void add(int key, int val) {
        OrderedList<Integer> tmplist = new OrderedList<>();//new ordered list

        /*check whether the value(list) have any list or not
        if it has, then we need to add the value into the list.
        if not create new list and add the value in it and assign it to the value part
         */
        if (map.get(key) == null) {
            tmplist.add(val);
            map.put(key, tmplist);
        } else {
            tmplist = map.get(key);
            tmplist.add(val);
        }
    }

    //to print the map. it is just for displaying purpose
    void printMap() {
        for (int i : map.keySet()) {
            System.out.print("Key:" + i + "  Value:");
            if (map.get(i) != null) {
                Node head = map.get(i).head;
                while (head != null) {
                    System.out.print(head.data + ",");
                    head = head.next;
                }
                System.out.println();
            } else {
                System.out.print("No data");
            }
        }

    }

    /*To search a value in the map.
    we can achieve this by looping through all the values(list)
     */
    int search(int value) {
        for (int i : map.keySet()) {
            if (map.get(i) != null) {
                if (map.get(i).search(value)) {
                    return i;
                }
            }
        }
        return -1;
    }
}
