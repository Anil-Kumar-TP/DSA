package com.anil.src;

import java.util.Arrays;

public class LongestConsecutiveSequenceInArrayBetter {
    public static void main(String[] args) {
        int[] arr = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        int ans = longest(arr);
        System.out.println(ans);
    }

    private static int longest(int[] arr) {
        if (arr.length == 0){
            return 0;
        }
        Arrays.sort(arr);

        int longest = 1;
        int currentCount = 0;
        int lastSmaller = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++){
            if (arr[i] - 1 == lastSmaller){
                currentCount = currentCount + 1;
                lastSmaller = arr[i];
            }else if (arr[i] != lastSmaller){
                currentCount = 1;
                lastSmaller = arr[i];
            }

            longest = Math.max(longest,currentCount);
        }

        return longest;
    }
}
