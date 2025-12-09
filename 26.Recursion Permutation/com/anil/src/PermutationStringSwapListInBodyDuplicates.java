package com.anil.src;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PermutationStringSwapListInBodyDuplicates {
    public static void main(String[] args) {
        String str = "aba";
        char[] chars = str.toCharArray();
        List<String> ans = permutation(chars, 0);
        System.out.println(ans);
    }

    private static List<String> permutation(char[] arr, int start) {
        List<String> list = new ArrayList<>();
        if (start == arr.length - 1){
            list.add(new String(arr));
            return list;
        }

//        Java's String class has a constructor explicitly designed to accept a primitive array of characters (char[]) and perform the deep copy internally.
//        thus we can just say list.add(new String(arr))
        //we cant say that for Integer array
        //PermutationArraysWithDuplicateSwap refer this
        //here a deep copy is made



        Set<Character> seen = new HashSet<>();

        for (int i = start; i < arr.length; i++){
            if (seen.contains(arr[i])){
                continue;
            }
            seen.add(arr[i]);
            swap(arr,i,start);
            list.addAll(permutation(arr,start + 1));
            swap(arr,i,start);
        }

        return list;
    }

    private static void swap(char[] arr, int first, int second) {
        char temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
