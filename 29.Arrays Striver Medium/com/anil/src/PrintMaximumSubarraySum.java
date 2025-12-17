package com.anil.src;

import java.util.Arrays;

//extension of kadane's algorithm.
public class PrintMaximumSubarraySum {
    public static void main(String[] args) {
        int[] arr = {2, 3, 5, -2, 7, -4};
        int[] ans = printMaxSubArraySum(arr);
        System.out.println(Arrays.toString(ans));
    }

    private static int[] printMaxSubArraySum(int[] arr) {
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        int start = 0;
        int ansStart = -1;
        int ansEnd = -1;

        for (int i = 0; i < arr.length; i++){

            if (sum == 0) {
                start = i;
            }

            sum = sum + arr[i];

            if (sum > maxSum){
                maxSum = sum;
                ansStart = start;
                ansEnd = i;
            }

            if (sum < 0){
                sum = 0;
            }
        }

        System.out.print("[");
        for (int i = ansStart; i <= ansEnd; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.print("]");
        return new int[]{ansStart,ansEnd};
    }
}
