package com.anil.src;

import java.util.ArrayList;
import java.util.List;

public class PermutationStringSwapListInBody {
    public static void main(String[] args) {
        String str = "abc";
        char[] chars = str.toCharArray();
        List<String> ans = permutation(chars,0);
        System.out.println(ans);
    }

    private static List<String> permutation(char[] arr, int start) {
        List<String> list = new ArrayList<>();
        if (start == arr.length - 1){
            list.add(new String(arr));
            return list;
        }

        for (int i = start; i < arr.length; i++){
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


//❗ Why no accumulator param?
//
//        Because swap-based recursion already mutates the array, so an accumulator parameter becomes unnecessary and confusing.