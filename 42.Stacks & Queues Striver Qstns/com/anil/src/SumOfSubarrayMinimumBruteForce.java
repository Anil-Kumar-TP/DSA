package com.anil.src;

public class SumOfSubarrayMinimumBruteForce {
    public static void main(String[] args) {
        int[] arr = {3,1,2,4};
        int ans = sumOfSubarrayMinimum(arr);
        System.out.println(ans);
    }

    private static int sumOfSubarrayMinimum(int[] arr) {
        int sum = 0;

        for (int i = 0; i < arr.length; i++){
            int minimum = Integer.MAX_VALUE;
            for (int j = i; j < arr.length; j++){
                minimum = Math.min(minimum,arr[j]);
                sum = sum + minimum;
            }
        }

        return sum;
    }
}
