package com.anil.src;

public class SumOfSubarrayRangesBruteForce {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        long ans = sumOfSubarrayRanges(arr);
        System.out.println(ans);
    }

    private static long sumOfSubarrayRanges(int[] arr) {
        int sum = 0;

        for (int i = 0; i < arr.length; i++){
            int minimum = arr[i];
            int maximum = arr[i];
            for (int j = i; j < arr.length; j++){
                minimum = Math.min(minimum,arr[j]);
                maximum = Math.max(maximum,arr[j]);
                sum = sum + (maximum - minimum);
            }
        }

        return sum;
    }
}
