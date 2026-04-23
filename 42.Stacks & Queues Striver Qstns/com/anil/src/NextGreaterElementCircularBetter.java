package com.anil.src;

import java.util.Arrays;

public class NextGreaterElementCircularBetter {
    public static void main(String[] args) {
        int[] arr = {1,2,1};
        int[] ans = nextGreaterElement(arr);
        System.out.println(Arrays.toString(ans));
    }

    private static int[] nextGreaterElement(int[] arr) {
        int[] result = new int[arr.length];
        int n = arr.length;

        for (int i = 0; i < arr.length; i++){
            result[i] = -1;
            for (int j = i + 1; j < i + n; j++){
                int nextIndex = j % n;
                if (arr[nextIndex] > arr[i]){
                    result[i] = arr[nextIndex];
                    break;
                }
            }
        }

        return result;
    }
}
