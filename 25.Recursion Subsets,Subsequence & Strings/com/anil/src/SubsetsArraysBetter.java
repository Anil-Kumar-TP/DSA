package com.anil.src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsArraysBetter {
    public static void main(String[] args) {
        int[] arr = {1,2,2};
        Arrays.sort(arr);//we can sort bcs it is a subset.
        List<List<Integer>> ans = new ArrayList<>();
        List<List<Integer>> result = subsets(arr,0,new ArrayList<>(),ans);
        System.out.println(result);
    }

    private static List<List<Integer>> subsets(int[] arr, int start, ArrayList<Integer> path, List<List<Integer>> list) {
       list.add(new ArrayList<>(path));
        for (int i = start; i < arr.length; i++){
            //remove this if the elements are unique and distinct
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

//    add current path
//        for each i from start → end:
//        choose
//        recurse
//        un-choose



//    In DFS-loop-style subsets, you should NOT have a base case that returns early.
//
//        Instead, you must add the current path before the loop, otherwise:
//
//        the empty subset is missing
//
//        subsets that don’t reach leaf will be missed