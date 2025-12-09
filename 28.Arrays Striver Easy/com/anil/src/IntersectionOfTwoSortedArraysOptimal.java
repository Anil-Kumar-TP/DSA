package com.anil.src;

import java.util.ArrayList;
import java.util.List;

public class IntersectionOfTwoSortedArraysOptimal {
    public static void main(String[] args) {
        int[] arr1 = {1,2,2,3,3,4,5,6};
        int[] arr2 = {2,3,3,5,6,6,7};
        List<Integer> ans = intersection(arr1, arr2);
        System.out.println(ans);
    }

    private static List<Integer> intersection(int[] arr1, int[] arr2) {
        int i = 0;
        int j = 0;

        List<Integer> ans = new ArrayList<>();

        while (i < arr1.length && j < arr2.length){
            if (arr1[i] < arr2[j]){
                i++;
            }else if (arr2[j] < arr1[i]){
                j++;
            }else {
                ans.add(arr1[i]);
                i++;
                j++;
            }
        }
        return ans;
    }
}
