package com.anil.src;

import java.util.HashMap;
import java.util.Map;

//not sliding window cus negatives can be there.
public class CountSubArraySumEqualsKOptimal {
    public static void main(String[] args) {
        int k = 6;
        int[] arr = {3,1,2,4};
        int ans = countSubarray(arr,k);
        System.out.println(ans);
    }

    private static int countSubarray(int[] arr, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);

        int prefixSum = 0;
        int count = 0;

        for (int num : arr){
            prefixSum = prefixSum + num;

            int target = prefixSum - k;

            if (map.containsKey(target)){
                count = count + map.get(target);
            }

            map.put(prefixSum,map.getOrDefault(prefixSum,0) + 1);
        }

        return count;
    }
}


//1. The "Start of the Array" ProblemIf your very first element is exactly $K$ (e.g., $K=6$ and the array is [6, 1, 2]), your code will do this:prefixSum becomes 6.target = prefixSum - k $\implies$ 6 - 6 = 0.The code looks in the map for 0.If you didn't put {0: 1} in the map, the code will say, "I haven't seen a 0 before!" and it will skip the very first valid subarray.