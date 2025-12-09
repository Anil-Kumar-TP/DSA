package com.anil.src;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicatesBruteForce {
    public static void main(String[] args) {
        int[] arr = {1,1,1,2,2,3,3};
        int count = duplicates(arr);
        System.out.println(count);
        System.out.println(Arrays.toString(arr));
    }

    private static int duplicates(int[] arr) {
        Set<Integer> seen = new LinkedHashSet<>();//to preserve order.
        for (int num : arr){
            seen.add(num);
        }

        int index = 0;
        for (int uniqueNum : seen){
            arr[index] = uniqueNum;
            index++;
        }

        //after unique replaced with -1.
        for (int i = index; i < arr.length; i++){
            arr[i] = -1;
        }

        return index;
    }
}
