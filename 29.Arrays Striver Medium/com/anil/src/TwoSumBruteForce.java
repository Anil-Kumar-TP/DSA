package com.anil.src;

import java.util.Arrays;

public class TwoSumBruteForce {
    public static void main(String[] args) {
        int[] arr = {2,6,5,8,11};
        int target = 14;
        int[] ans = twoSum(arr,target);
        System.out.println(Arrays.toString(ans));
    }

    private static int[] twoSum(int[] arr, int target) {
        for (int i = 0; i < arr.length - 1; i++){
            for(int j = i + 1; j < arr.length; j++){
                if (arr[i] + arr[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{-1,-1};
    }
}

//2 with 6,5,8,11
//        6 with 5,8,11
//        5 with 8,11
//        8 with 11



//The key: Two Sum needs unordered unique pairs, not “check all with all”
//
//A pair {i, j} is the same as {j, i}.
//Order does not matter.
//
//So:
//
//Checking (0,1) and (1,0) is duplicate work.
//
//Checking (i,i) is invalid.
//
//Checking (0,1) once is enough.

//that is why for j we did not start again with j = 0 rather j = i + 1 as the order would be same