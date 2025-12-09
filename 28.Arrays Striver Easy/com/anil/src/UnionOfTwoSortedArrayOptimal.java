package com.anil.src;

import java.util.ArrayList;
import java.util.List;

public class UnionOfTwoSortedArrayOptimal {
    public static void main(String[] args) {
        int[] arr1 = {1,1,6};
        int[] arr2 = {1,2,3};
        List<Integer> ans = union(arr1, arr2);
        System.out.println(ans);
    }

    private static List<Integer> union(int[] arr1, int[] arr2) {
        int i = 0;
        int j = 0;

        List<Integer> union = new ArrayList<>();

        while (i < arr1.length && j < arr2.length){
            if (arr1[i] < arr2[j]){
                if (union.isEmpty() || union.get(union.size() - 1) != arr1[i]){
                    union.add(arr1[i]);
                }
                i++;
            }
            else if (arr2[j] < arr1[i]){
                if (union.isEmpty() || union.get(union.size() - 1) != arr2[j]){
                    union.add(arr2[j]);
                }
                j++;
            }else {
                if (union.isEmpty() || union.get(union.size() - 1) != arr1[i]) {
                    union.add(arr1[i]);
                }
                i++;
                j++;
            }
        }

        while (i < arr1.length) {
            if (union.isEmpty() || union.get(union.size() - 1) != arr1[i])
                union.add(arr1[i]);
            i++;
        }

        // Append remaining elements from arr2
        while (j < arr2.length) {
            if (union.isEmpty() || union.get(union.size() - 1) != arr2[j])
                union.add(arr2[j]);
            j++;
        }

        // Return the union list
        return union;
    }
}
