package com.anil.src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsStringsBetterReturnTypeStringOther {
    public static void main(String[] args) {
        String str = "abc";
        char[] arr = str.toCharArray();
        Arrays.sort(arr);

        List<List<String>> ans = new ArrayList<>();
        List<List<String>> result = subsets(arr, 0, new ArrayList<>(), ans);

        System.out.println(result);
    }

    private static List<List<String>> subsets(char[] arr, int start, ArrayList<String> path, List<List<String>> list) {
        list.add(new ArrayList<>(path));
        for (int i = start; i < arr.length; i++) {
            if (i > start && arr[i] == arr[i - 1]) continue;
            path.add(String.valueOf(arr[i]));
            subsets(arr, i + 1, path, list);
            path.remove(path.size() - 1);
        }

        return list;
    }
}
