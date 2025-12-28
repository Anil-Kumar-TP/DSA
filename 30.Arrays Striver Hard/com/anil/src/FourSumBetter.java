package com.anil.src;

import java.util.*;

public class FourSumBetter {
    public static void main(String[] args) {
        int[] arr = {1,0,-1,0,-2,2};
        int target = 0;
        List<List<Integer>> ans = fourSum(arr, target);
        System.out.println(ans);
    }

    private static List<List<Integer>> fourSum(int[] arr, int target) {
        Set<List<Integer>> ans = new HashSet<>();

        for (int i = 0; i < arr.length; i++){
            for (int j = i + 1; j < arr.length; j++){
                Set<Integer> set = new HashSet<>();
                for (int k = j + 1; k < arr.length; k++){
                    long remaining = (long) target - (arr[i] + arr[j] + arr[k]);
                    if (set.contains((int) remaining)){
                        List<Integer> temp = Arrays.asList(arr[i],arr[j],arr[k],(int) remaining);
                        Collections.sort(temp);
                        ans.add(temp);
                    }

                    set.add(arr[k]);
                }
            }
        }
        return new ArrayList<>(ans);
    }
}
