package com.anil.src;

import java.util.HashMap;
import java.util.Map;

public class LargestSubarrayWithZeroSumOptimal {
    public static void main(String[] args) {
        int[] arr = {9, -3, 3, -1, 6, -5};
        int ans = largestSubarray(arr);
        System.out.println(ans);
    }

    private static int largestSubarray(int[] arr) {
         int maxLength = 0;

        Map<Integer,Integer> map = new HashMap<>();

        map.put(0,-1);//in length prblms it is -1 and in count prblms it is 1.

        int sum = 0;

        for (int i = 0; i < arr.length; i++){
            sum = sum + arr[i];

            if (map.containsKey(sum)){
                int prevIndex = map.get(sum);
                int currentLength = i - prevIndex;
                maxLength = Math.max(maxLength, currentLength);
            }else {
                map.put(sum,i);
            }
        }

        return maxLength;
    }
}

//map.get(sum) = earliest index where this sum occurred
//i - map.get(sum) → length of subarray between them