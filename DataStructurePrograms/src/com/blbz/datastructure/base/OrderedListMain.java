package com.blbz.datastructure.base;


import java.io.IOException;

public class OrderedListMain {

    public static void main(String[] args) throws IOException {
        OrderedList<Integer> ordlist = new OrderedList<>();//initiating Ordered list class
        for (String s:Utillity.readlistfile("/home/admin1/Desktop/Tamilselvan/Program/DataStructurePrograms/src/com/company/intval.txt")) {
            ordlist.add(Integer.parseInt(s));
        }
        Utillity.writeListData(ordlist.head);
        System.out.println("Lenght of the list "+ordlist.size());
    }
}
