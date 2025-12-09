package com.anil.src;

import java.util.Arrays;

public class SecondLargestElementBruteForce {
    public static void main(String[] args) {
        int[] arr = {1,4,2,9,9,5};
        int ans = secondLargest(arr);
        System.out.println(ans);
    }

    private static int secondLargest(int[] arr) {
        Arrays.sort(arr);
        int largest = arr[arr.length - 1];
        for (int i = arr.length - 2; i >= 0; i--){
            if (arr[i] != largest) {
                return arr[i];
            }
        }
        return -1;
    }
}
