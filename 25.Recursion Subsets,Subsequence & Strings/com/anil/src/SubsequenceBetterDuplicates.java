package com.anil.src;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubsequenceBetterDuplicates {
    public static void main(String[] args) {
        int[] arr = {1,2,2};
        Set<List<Integer>> resultSet = new HashSet<>();//Because a subsequence is a LIST of numbers — NOT a
        subsequence(arr, 0, new ArrayList<>(), resultSet);//single number.so set of list
        List<List<Integer>> ans = new ArrayList<>(resultSet);
        System.out.println(ans);
    }

    private static void subsequence(int[] arr, int index, List<Integer> path, Set<List<Integer>> set) {
        if (index == arr.length) {
            set.add(new ArrayList<>(path));
            return;
        }

        path.add(arr[index]);
        subsequence(arr, index + 1, path, set);
        path.remove(path.size() - 1);

        subsequence(arr, index + 1, path, set);
    }
}
