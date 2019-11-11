package com.company;

import java.util.Arrays;
//import java.util.Scanner;

class BinarySearch {
    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String filepath ="/home/admin1/Desktop/Tamilselvan/Program/Algorithm Programs/src/com/company/test.csv";
        String[] wordarr = readData(filepath);
        if (wordarr != null) {
            int low = 0, high = wordarr.length, mid = 0;
            mid = wordarr.length / 2;
            System.out.println("Please enter the word to search:");
            String word = sc.nextLine();
            String result = binarySearchmethod(word, wordarr, low, high, mid);
            System.out.println(result);
        }
    }*/


    static String binarySearchmethod(String word, String[] words, int low, int high, int mid) {
        Arrays.sort(words);
        while (low <= high) {
            if (words[mid].equals( word)) {
                return "Found at index " + mid;
            } else if (words[mid].compareTo(word) > 0) {
                high = mid - 1;
                mid = (low + high) / 2;
            } else if (words[mid].compareTo(word) < 0) {
                low = mid + 1;
                mid = (low + high) / 2;
            }
        }
        return "Not found";
    }
}
