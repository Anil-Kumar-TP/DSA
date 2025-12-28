package com.anil.src;

import java.util.HashMap;
import java.util.Map;

public class CountSubarraysWithXorAsKOptimal {
    public static void main(String[] args) {
        int[] arr = {4, 2, 2, 6, 4};
        int k = 6;
        int ans = countSubarrays(arr,k);
        System.out.println(ans);
    }

    private static int countSubarrays(int[] arr, int targetXor) {
        Map<Integer,Integer> prefixXorFrequency = new HashMap<>();

        prefixXorFrequency.put(0,1);

        int currentXor = 0;
        int count = 0;

        for (int num : arr){
            currentXor = currentXor ^ num;

            int requiredPrefixXor = currentXor ^ targetXor;

            if (prefixXorFrequency.containsKey(requiredPrefixXor)){
                int frequency = prefixXorFrequency.get(requiredPrefixXor);
                count = count + frequency;
            }

            prefixXorFrequency.put(currentXor,prefixXorFrequency.getOrDefault(currentXor,0) + 1);
        }

        return count;
    }
}
