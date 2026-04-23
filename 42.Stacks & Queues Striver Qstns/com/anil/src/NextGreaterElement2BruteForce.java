package com.anil.src;

import java.util.Arrays;

public class NextGreaterElement2BruteForce {
    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 4};
        int[] ans = nextGreater(arr);
        System.out.println(Arrays.toString(ans));
    }

    private static int[] nextGreater(int[] arr) {
        int[] result = new int[arr.length];

        for (int i = 0; i < arr.length; i++){
            result[i] = -1;
            for (int j = i + 1; j < arr.length; j++){
                if (arr[j] > arr[i]){
                    result[i] = arr[j];
                    break;
                }
            }
        }

        return result;
    }
}
