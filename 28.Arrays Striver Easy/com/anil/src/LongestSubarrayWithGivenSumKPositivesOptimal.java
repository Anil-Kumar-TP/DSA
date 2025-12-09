package com.anil.src;

//optimal for arrays with positives and zeroes
public class LongestSubarrayWithGivenSumKPositivesOptimal {
    public static void main(String[] args) {
        int[] arr = {1,2,3,1,1,1,1,4,2,3};
        int k = 3;
        int ans = lengthOfLongestSubarray(arr,k);
        System.out.println(ans);
    }

    private static int lengthOfLongestSubarray(int[] arr, int k) {
        int left = 0;
        int sum = 0;
        int maxLength = 0;

        for (int right = 0; right < arr.length; right++){
            sum = sum + arr[right];

            // While sum > k → shrink from left
            while (sum > k){
                sum = sum - arr[left];
                left++;
            }

            if (sum == k){
                maxLength = Math.max(maxLength,right - left + 1);
            }
        }
        return maxLength;
    }
}
