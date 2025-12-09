package com.anil.src;

public class LongestSubarrayWithGivenSumKPositivesBruteForceOther {
    public static void main(String[] args) {
        int[] arr = {1,2,3,1,1,1,1,4,2,3};
        int k = 3;
        int ans = lengthOfLongestSubarray(arr,k);
        System.out.println(ans);
    }

    private static int lengthOfLongestSubarray(int[] arr, int k) {
        int maxLength = 0;
        for (int i = 0; i < arr.length; i++){
            int sum = 0;
            for (int j = i; j < arr.length; j++){
                sum = sum + arr[j];

                if (sum == k){
                    maxLength = Math.max(maxLength,j - i + 1);
                }
            }

        }
        return maxLength;
    }
}
