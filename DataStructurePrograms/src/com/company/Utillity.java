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
    static String[] readlistfile() throws IOException {
        String[] tempstr=null;
        listFile=new BufferedReader(new FileReader("/home/admin1/Desktop/Tamilselvan/Program/DataStructurePrograms/src/com/company/in.txt"));
        String tmp=listFile.readLine();
        while (tmp!=null){
            tempstr=tmp.split("\\s");
            tmp=listFile.readLine();
        }
        return tempstr;
    }
}
