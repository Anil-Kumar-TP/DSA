package com.anil.src;

import java.util.*;

public class FourSumBruteForce {
    public static void main(String[] args) {
        int[] arr = {1,0,-1,0,-2,2};
        int target = 0;
        List<List<Integer>> ans = fourSum(arr,target);
        System.out.println(ans);
    }

    private static List<List<Integer>> fourSum(int[] arr, int target) {
        Set<List<Integer>> ans = new HashSet<>();

        for (int i = 0; i < arr.length; i++){
            for (int j = i + 1; j < arr.length; j++){
                for (int k = j + 1; k < arr.length; k++){
                    for (int l = k + 1; l < arr.length; l++){
                        long sum = (long) arr[i] + arr[j] + arr[k] + arr[l];
                        if (sum == target){
                            List<Integer> temp = Arrays.asList(arr[i],arr[j],arr[k],arr[l]);
                            Collections.sort(temp);
                            ans.add(temp);
                        }
                    }
                }
            }
        }

        return new ArrayList<>(ans);
    }
}
