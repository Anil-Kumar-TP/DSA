package com.anil.src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsStringsBetterReturnTypeChar {
    public static void main(String[] args) {
        String str = "abc";
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        List<List<Character>> list = new ArrayList<>();
        List<List<Character>> ans = subsets(chars,0,new ArrayList<>(),list);
        System.out.println(ans);
    }

    private static List<List<Character>> subsets(char[] arr, int start, ArrayList<Character> path, List<List<Character>> list) {
        list.add(new ArrayList<>(path));
        for (int i = start; i < arr.length; i++){
            if (i > start && arr[i] == arr[i - 1]){
                continue;
            }
            path.add(arr[i]);
            subsets(arr,i + 1,path,list);
            path.remove(path.size() - 1);
        }
        return list;
    }
}


//    The List<List<Character>> version is the most appropriate and efficient way to return subsets of characters. Commit to this version.