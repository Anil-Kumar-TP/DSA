package com.anil.src;

import java.util.HashMap;
import java.util.Map;

public class LongestSubarrayWithGivenSumKPositivesBetter {
    public static void main(String[] args) {
        int[] arr = {1,2,3,1,1,1,1,4,2,3};
        int k = 3;
        int ans = lengthOfLongestSubarray(arr,k);
        System.out.println(ans);
    }

    private static int lengthOfLongestSubarray(int[] arr, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int prefixSum = 0;
        int maxLength = 0;
        for (int i = 0; i < arr.length; i++){
            prefixSum = prefixSum + arr[i];

            if (prefixSum == k){
                maxLength = Math.max(maxLength,i + 1);
            }

            if (map.containsKey(prefixSum - k)){
                int prevIndex = map.get(prefixSum - k);
                maxLength = Math.max(maxLength,i - prevIndex);
            }

            if (!map.containsKey(prefixSum)){
                map.put(prefixSum,i);
            }
        }
        return maxLength;
    }
}


//Index:     0   1   2   3   4   5   6   7   8   9
//Array:     1   2   3   1   1   1   1   4   2   3
//Prefix:    1   3   6   7   8   9  10  14  16  19
//
//
//You’re at index 5, prefix sum = 9
//You ask yourself:
//        “Has there ever been a time when I had 9 - 3 = 6 in my pocket before?”
//Yes! At index 2 → prefix sum was 6
//So from index 3 to 5:
//textarr[3] + arr[4] + arr[5] = 1 + 1 + 1 = 3 → k!
//Length = 5 - 2 = 3 → found!


//for each index i:
//sum += arr[i]
//
//        if (sum == k) → "From start to here = k → update length"
//
//        if (I've seen sum - k before) → "From that point to now = k → update length"
//
//        if (I've never seen this sum before) → "Remember: at i, sum was X"



//If prefixSum - k exists in the map, it means there is a subarray between prevIndex+1 and i whose sum is k.
//prefixSum = sum(0 ... i)
//prefixSum - k = sum(0 ... prevIndex)
//=> sum(prevIndex+1 ... i) = k
