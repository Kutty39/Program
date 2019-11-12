package com.company;

public class AnagramDetection {
    public static String find(String s, String s1) {
        String[] permutaion = Permutations.findPermutations(s);
        BinarySearch<String> bs = new BinarySearch<>();
        String result = bs.binarySearchmethod(permutaion, s1);
        if (result.equals("Not found")) {
            return "not an Anagram";
        }
        return "an Anagram";
    }
}
