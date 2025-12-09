package com.anil.src;

import java.util.ArrayList;
import java.util.List;

public class ListInBody {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,4,5,7};
        int target = 4;
        List<Integer> ans = occurrence(arr,target,0);
        System.out.println(ans);
    }

    private static List<Integer> occurrence(int[] arr, int target,int index) {

        ArrayList<Integer> list = new ArrayList<>();

        if (index == arr.length){
            return list;
        }
        if (arr[index] == target){
            list.add(index);
        }

        List<Integer> ansFromBelow = occurrence(arr,target,index + 1);
        list.addAll(ansFromBelow);
        return list;
    }
}
