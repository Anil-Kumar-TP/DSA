package com.anil.src;

import java.util.ArrayList;

public class GlobalList {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,4,5,7};
        int target = 4;
        occurrence(arr,target,0);
    }

    static ArrayList<Integer> list = new ArrayList<>();
    private static void occurrence(int[] arr, int target, int index) {
        if (index == arr.length){
            System.out.println(list);
            return;
        }
        if (arr[index] == target){
            list.add(index);
        }
        occurrence(arr,target,index + 1);
    }
}
