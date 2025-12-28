package com.anil.src;

import java.util.Arrays;

public class MissingAndRepeatingNumbersBetter {
    public static void main(String[] args) {
        int[] arr = {3, 5, 4, 1, 1};
        int[] ans = missingAndRepeating(arr);
        System.out.println(Arrays.toString(ans));
    }

    private static int[] missingAndRepeating(int[] arr) {
        int n = arr.length;
        int[] hash = new int[n + 1];

        for (int i = 0; i < n; i++){
            hash[arr[i]]++;
        }

        int repeatingNumber = -1;
        int missingNumber = -1;

        for (int i = 1; i <= n; i++){
            if (hash[i] == 2){
                repeatingNumber = i;
            }else if (hash[i] == 0){
                missingNumber = i;
            }

            if (missingNumber != -1 && repeatingNumber != -1){
                break;
            }
        }

        return new int[]{repeatingNumber,missingNumber};
    }
}
