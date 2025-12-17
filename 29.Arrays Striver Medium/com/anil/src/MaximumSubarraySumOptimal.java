package com.anil.src;

//kadane's Algorithm
//for brute and better it is similar Longest Subarray sum
public class MaximumSubarraySumOptimal {
    public static void main(String[] args) {
        int[] arr = {2, 3, 5, -2, 7, -4};
        int ans = maxSubArraySum(arr);
        System.out.println(ans);
    }

    private static int maxSubArraySum(int[] arr) {
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++){
            sum = sum + arr[i];

            if (sum > maxSum){
                maxSum = sum;
            }

            if (sum < 0){
                sum = 0;
            }
        }

        if (maxSum < 0){ //add this only when the qstn explicitly tells empty subarrays are possible.
            maxSum = 0;
        }

        return maxSum;
    }
}
