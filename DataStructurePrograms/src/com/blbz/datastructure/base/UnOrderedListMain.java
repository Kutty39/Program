package com.blbz.datastructure.base;

import java.io.IOException;

public class UnOrderedListMain {
    public static void main(String[] args) throws IOException {
        UnOrderedList<String> list = new UnOrderedList<>();//initiating list class
        Utillity utl=new Utillity();
        for (String s:Utillity.readlistfile("/home/admin1/Desktop/Tamilselvan/Program/DataStructurePrograms/src/com/company/in.txt")) {
            list.add(s);
        }
        Utillity.printlist(list.head);
        System.out.println("Lenght of the list "+list.size());
    }
}
