package com.anil.src;

import java.util.HashSet;
import java.util.Set;

public class PermutationStringDuplicatesWithSet {
    public static void main(String[] args) {
        permutation("","aac");
    }

    private static void permutation(String finalOne, String initialOne) {
        if (initialOne.isEmpty()){
            System.out.println(finalOne);
            return;
        }
        char ch = initialOne.charAt(0);
        Set<String> seen = new HashSet<>();
        for (int i = 0; i <= finalOne.length(); i++){
            String first = finalOne.substring(0,i);
            String second = finalOne.substring(i,finalOne.length());
            String newString = first + ch + second;

            if (seen.contains(newString)){
                continue;
            }
            seen.add(newString);

            permutation(newString,initialOne.substring(1));
        }
    }
}
