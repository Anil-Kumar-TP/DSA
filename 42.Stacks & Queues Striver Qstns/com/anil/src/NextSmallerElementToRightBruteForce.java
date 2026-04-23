package com.anil.src;

import java.util.Arrays;

public class NextSmallerElementToRightBruteForce {
    public static void main(String[] args) {
        int[] arr = {4, 5, 2, 10, 8};
        int[] ans = nextSmallerToRight(arr);
        System.out.println(Arrays.toString(ans));
    }

    private static int[] nextSmallerToRight(int[] arr) {
        int[] result = new int[arr.length];

        for (int i = 0; i < arr.length; i++){
            result[i] = -1;
            for (int j = i + 1; j < arr.length; j++){
                if (arr[j] < arr[i]){
                    result[i] = arr[j];
                    break;
                }
            }
        }

        return result;
    }
}
