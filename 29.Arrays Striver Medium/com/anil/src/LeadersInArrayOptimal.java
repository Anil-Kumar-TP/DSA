package com.anil.src;

import java.util.ArrayList;
import java.util.List;

public class LeadersInArrayOptimal {
    public static void main(String[] args) {
        int[] arr = {10,22,12,3,0,6};
        List<Integer> ans = leaders(arr);
        System.out.println(ans);
    }

    private static List<Integer> leaders(int[] arr) {
        List<Integer> ans = new ArrayList<>();

        if (arr.length == 0){
            return ans;
        }

        //last element is always a leader
        int max = arr[arr.length - 1];

        ans.add(arr[arr.length - 1]);

        for (int i = arr.length - 2; i >= 0; i--){
            if (arr[i] > max){
                ans.add(arr[i]);
                max = arr[i];
            }
        }

        return ans;
    }
}
