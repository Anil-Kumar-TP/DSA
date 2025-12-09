package com.anil.src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsStringsBetterReturnTypeString {
    public static void main(String[] args) {
        String str = "abc";
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>();
        List<String> ans = subset(chars,0,sb,list);
        System.out.println(ans);
    }

    private static List<String> subset(char[] arr, int start, StringBuilder path, List<String> list) {
        list.add(path.toString());
        for (int i = start; i < arr.length; i++) {
            if (i > start && arr[i] == arr[i - 1]) continue;
            path.append(arr[i]);
            subset(arr, i + 1, path, list);
            path.deleteCharAt(path.length() - 1);
        }
        return list;
    }
}
//note the return type is here just List and not List of List
