package com.anil.src;

import java.util.ArrayList;
import java.util.List;

public class ParameterList {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,4,5,7};
        int target = 4;
        List<Integer> ans = occurrence(arr, target, 0, new ArrayList<Integer>());
        System.out.println(ans);
    }

    private static List<Integer> occurrence(int[] arr, int target, int index, ArrayList<Integer> list) {
        if (index == arr.length){
            return list;
        }
        if (arr[index] == target){
            list.add(index);
        }
        return occurrence(arr,target,index + 1,list);
    }
}
