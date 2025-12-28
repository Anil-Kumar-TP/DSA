package com.anil.src;

public class LargestSubarrayWithZeroSumBruteForce{
    public static void main(String[] args) {
        int[] arr = {9, -3, 3, -1, 6, -5};
        int ans = largestSubarray(arr);
        System.out.println(ans);
    }

    private static int largestSubarray(int[] arr) {
        int maxLength = 0;

        for (int i = 0; i < arr.length; i++){
            for (int j = i; j < arr.length; j++){
                int sum = 0;
                for (int k = i; k <= j; k++){
                    sum = sum + arr[k];
                }

                if (sum == 0){
                    maxLength = Math.max(maxLength,j - i + 1);
                }
            }
        }

        return maxLength;
    }
}
