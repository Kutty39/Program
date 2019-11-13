package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Utillity {
    static Scanner sc=new Scanner(System.in);
    static BufferedReader listFile;

    public Utillity() {

    }
    //read text file
    static String[] readlistfile() throws IOException {
        String[] tempstr=null;
        listFile=new BufferedReader(new FileReader("/home/admin1/Desktop/Tamilselvan/Program/DataStructurePrograms/src/com/company/intval.txt"));
        String tmp=listFile.readLine();
        while (tmp!=null){
            tempstr=tmp.split("\\s");
            tmp=listFile.readLine();
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
    Node next = null;
}

class InsertionSort<T extends Comparable> {
    public T[] sorting(T[] s) {
        for (int i = 0; i < s.length; i++) {
            int j = i - 1;
            int k = i;
            while (j >= 0) {
                if (s[j].compareTo(s[k]) > 0) {
                    T tmp = s[j];
                    s[j] = s[k];
                    s[k] = tmp;
                } else {
                    break;
                }
                --j;
                --k;
            }
        }
        return s;
    }
}

