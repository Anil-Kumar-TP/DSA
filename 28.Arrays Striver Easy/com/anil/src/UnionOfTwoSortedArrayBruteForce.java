package com.anil.src;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class UnionOfTwoSortedArrayBruteForce {
    public static void main(String[] args) {
        int[] arr1 = {1,1,2,3,4,5};
        int[] arr2 = {2,3,4,4,5,6};
        int[] ans = union(arr1,arr2);
        System.out.println(Arrays.toString(ans));
    }

    private static int[] union(int[] arr1, int[] arr2) {
        Set<Integer> set = new LinkedHashSet<>();

        for (int num1 : arr1){
            set.add(num1);
        }

        for (int num2 : arr2){
            set.add(num2);
        }

        int[] temp = new int[set.size()];

        int index = 0;
        for (int n : set){
            temp[index] = n;
            index++;
        }

        return temp;
    }
}

//instead of array if we were using a list for ans
//just convert set to a list
//return new ArrayList<>(set);
