package com.anil.src;

import java.util.Arrays;

public class SlidingWindowMaximumBruteForce {
    public static void main(String[] args) {
        int[] arr = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] ans = slidingWindow(arr,k);
        System.out.println(Arrays.toString(ans));
    }

    private static int[] slidingWindow(int[] arr,int k) {
        int n = arr.length;
        int[] result = new int[n - k + 1];

        for (int i = 0; i <= n - k; i++){
            int max = arr[i];
            for (int j = i; j < i + k; j++){
                if (arr[j] > max) {
                    max = arr[j];
                }
            }

            result[i] = max;
        }

        return result;
    }
}
