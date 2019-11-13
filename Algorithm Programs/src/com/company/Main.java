package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        String filepath;
        String[] words;
        Scanner sc = new Scanner(System.in);
        System.out.println("1.Recursive Permutation\n2.Binary Search\n3.Insertion Sort\n4.Bubble Sort\n5.Merge Sort\n6.Anagram\n7.Prime number(0-1000)\n8.Find your number\n9.Message printer\nSelect the option from above.");
        switch (sc.nextLine()) {
            case "1":
                String[] permutation = Permutations.findPermutations("ABCD");
                printarr(permutation);
                break;
            case "2":
                filepath = "/home/admin1/Desktop/Tamilselvan/Program/Algorithm Programs/src/com/company/test.csv";
                String[] wordarr = readData(filepath);
                if (wordarr != null) {
                    System.out.println("Please enter the word to search:");
                    String word = sc.nextLine();
                    BinarySearch<String> bs = new BinarySearch<>();
                    String result = bs.binarySearchmethod(wordarr, word);
                    System.out.println(result);
                }
                break;
            case "3":
                filepath = "/home/admin1/Desktop/Tamilselvan/Program/Algorithm Programs/src/com/company/test.csv";
                words = readData(filepath);
                InsertionSort<String> ins=new InsertionSort<>();
                if (words != null) {
                    printarr(ins.sorting(words));
                }
                break;
            case "4":
                int[] i = {5, 4, 2, 8, 11, 90, 1};
                printarr(BubbleSort.bubbleSorting(i));
            case "5":
                filepath = "/home/admin1/Desktop/Tamilselvan/Program/Algorithm Programs/src/com/company/test.csv";
                words = readData(filepath);
                if (words != null) {
                    printarr(MergeSort.dividearray(words));
                    /*Arrays.sort(words);
                    printarr(words);*/
                }
                break;
            case "6":
                System.out.println("The strings which you have given is " + AnagramDetection.find("heart", "earth"));
                break;
            case "7":
                int[] prm = PrimeNumbers.find(0, 1000);
                printarr(prm);
                printarr(PrimeNumbers.pallindromeint(prm));
                printarr(PrimeNumbers.anagramint(prm));
                break;
            case "8":
                FindYourNumber.binarySearch(1000);
                break;
            case "9":
                System.out.println(MessagePrinter.replace());
                break;
            case "10":
                int t=12345;
                String s =String.valueOf(t);
                System.out.println(s.length());
        }

    }

    public static void printarr(String[] s) {
        System.out.println(Arrays.toString(s));
    }

    public static void printarr(int[] i) {
        System.out.println(Arrays.toString(i));
    }

    public static String[] readData(String s) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(s));
            return br.readLine().split(",");
        } catch (FileNotFoundException e) {
            System.out.println("File not exists");
            return null;
        } catch (IOException e) {
            System.out.println("No data available");
            return null;
        }

    }
}
