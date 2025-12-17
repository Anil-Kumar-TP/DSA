package com.anil.src;

import java.util.ArrayList;
import java.util.List;

public class LeadersInArrayUsingList {
    public static void main(String[] args) {
        int[] arr = {10,22,12,3,0,6};
        List<Integer> ans = leaders(arr);
        System.out.println(ans);
    }

    private static List<Integer> leaders(int[] arr) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < arr.length; i++){
            boolean leader = true;
            for (int j = i + 1; j < arr.length; j++){
                if (arr[j] > arr[i]){
                    leader = false;
                    break;
                }
            }

            if (leader){
                ans.add(arr[i]);
            }
        }

        return ans;
    }
}
