package com.anil.src;

import static com.anil.src.SumOfSubarrayMinimumOptimal.sumOfSubarrayMinimum;
import static com.anil.src.extraQstns.SumOfSubarrayMaximumOptimal.sumOfSubarrayMaximum;

public class SumOfSubarrayRangesOptimal {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        long ans = sumOfSubarrayRanges(arr);
        System.out.println(ans);
    }

    private static long sumOfSubarrayRanges(int[] arr) {
        long maxSum = sumOfSubarrayMaximum(arr);
        long minSum = sumOfSubarrayMinimum(arr);
        return maxSum - minSum;
    }
}
