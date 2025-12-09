package com.anil.src;

import java.util.ArrayList;
import java.util.List;

public class PermutationStringSwapListInParams {
    public static void main(String[] args) {
        String str = "abc";
        char[] chars = str.toCharArray();
        List<String> ans = permutation(chars,0,new ArrayList<>());
        System.out.println(ans);
    }

    private static List<String> permutation(char[] arr, int start, ArrayList<String> list) {
        if (start == arr.length - 1){
            list.add(new String(arr));
            return list;
        }

        for (int i = start; i < arr.length; i++){
            swap(arr,i,start);
            permutation(arr,start + 1,list);
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

//    Even though you “added accumulator”, you’re not using it to accumulate partial builds like with substring method.
//
//        Because swap method inherently builds the permutation inside the array.
