package com.anil.src;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSumOptimal {
    public static void main(String[] args) {
        int[] arr = {2,6,5,8,11};
        int target = 14;
        int[] ans = twoSum(arr,target);
        System.out.println(Arrays.toString(ans));
    }

    private static int[] twoSum(int[] arr, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++){
            int difference = target - arr[i];

            if (map.containsKey(difference)){
                return new int[]{map.get(difference),i};
            }

            map.put(arr[i],i);
        }

        return new int[]{-1,-1};
    }
}


//if we are not allowed to use map,only then use the 2 pointer where the left and right pointer
//starts off at the extremes and if left + right which is the sum is equal to the target return yes
//if sum is greater than target reduce from right and if sum is smaller increase from left.
//but this is fine only if the qstn variety is yes/ no . not for returning indices.