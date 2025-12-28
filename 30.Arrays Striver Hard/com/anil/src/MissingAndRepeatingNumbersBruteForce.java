package com.anil.src;

import java.util.Arrays;

public class MissingAndRepeatingNumbersBruteForce {
    public static void main(String[] args) {
        int[] arr = {3, 5, 4, 1, 1};
        int[] ans = missingAndRepeating(arr);
        System.out.println(Arrays.toString(ans));
    }

    private static int[] missingAndRepeating(int[] arr) {
        int missingNumber = -1;
        int repeatingNumber = -1;

        for (int i = 1; i <= arr.length; i++) {
            int count = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == i) {
                    count++;
                }
            }
            if (count == 2) {//notice the if is outside the for loop.
                repeatingNumber = i;
            } else if (count == 0) {
                missingNumber = i;
            }

            if (missingNumber != -1 && repeatingNumber != -1) {
                break;
            }
        }
        return new int[]{repeatingNumber,missingNumber};
    }
}
