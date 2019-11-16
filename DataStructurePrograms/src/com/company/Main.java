package com.company;

import java.io.IOException;

import static com.company.Utillity.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Utillity utillity = new Utillity();
        sc.reset();//initiating Scanner

//        // Unordered List
//        UnOrderedList<String> list = new UnOrderedList<>();//initiating list class
//        for (String s:readlistfile("/home/admin1/Desktop/Tamilselvan/Program/DataStructurePrograms/src/com/company/in.txt")) {
//            list.add(s);
//        }
//        printlist(list.head);
//        System.out.println("Lenght of the list "+list.size());
//
//        // Ordered List
//        OrderedList<Integer> ordlist = new OrderedList<>();//initiating Ordered list class
//        for (String s:utillity.readlistfile("/home/admin1/Desktop/Tamilselvan/Program/DataStructurePrograms/src/com/company/intval.txt")) {
//            ordlist.add(Integer.parseInt(s));
//        }
//        utillity.writeListData(ordlist.head);
//        System.out.println("Lenght of the list "+ordlist.size());
//
//        //Bank cash counter in Q
//        BankingCashCounter bp=new BankingCashCounter();
//        bp.peopleQ();

//        //
//        System.out.println("Enter the word to check palindrome");
//        String s=sc.nextLine();
//        if(s.equals(PalindromeChecker.check(s))){
//            System.out.println("Palindrome");
//        }else {
//            System.out.println("Not a Palindrome");
//        }


        //Hashing Function to search a Number in a slot
        HashingFunction hf = new HashingFunction();
        for (String s : utillity.readlistfile("/home/admin1/Desktop/Tamilselvan/Program/DataStructurePrograms/src/com/company/intval.txt")) {
            int tmp = Integer.parseInt(s);
            hf.add(tmp % 11, tmp);
        }
        hf.printMap();
        System.out.println("Please enter the number the search");
        int number = sc.nextInt();
        System.out.println("number " + number + " is " + (hf.search(number) != -1 ? ("found at " + hf.search(number)) : "not found"));
    }
}
