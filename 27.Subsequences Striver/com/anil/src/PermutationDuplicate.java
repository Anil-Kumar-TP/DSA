package com.anil.src;

import java.util.*;

public class PermutationDuplicate {
    public static void main(String[] args) {
        int[] arr = {1,2,1};
        Arrays.sort(arr);
        List<List<Integer>> res = new ArrayList<>();
        permute(arr, 0, res);
        System.out.println(res);
    }

    private static void permute(int[] arr, int index, List<List<Integer>> res) {

        if (index == arr.length) {
            List<Integer> temp = new ArrayList<>();
            for (int n : arr) temp.add(n);
            res.add(temp);
            return;
        }

        Set<Integer> used = new HashSet<>();

        for (int i = index; i < arr.length; i++) {

            // skip duplicates at this recursion depth
            if (used.contains(arr[i])) continue;
            used.add(arr[i]);

            swap(arr, index, i);
            permute(arr, index + 1, res);
            swap(arr, index, i);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

//Because the array itself is changing, you cannot trust arr[i] == arr[i-1]
//so we use set here unlike subsets or combinations