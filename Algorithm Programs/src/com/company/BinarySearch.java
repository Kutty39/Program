package com.company;

import java.util.Arrays;
//import java.util.Scanner;

class BinarySearch<T extends Comparable> {
    String binarySearchmethod(T[] words, T word) {
        int low = 0, high = words.length-1, mid;
        mid = words.length / 2;
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
