package com.anil.src;

import java.util.Arrays;

public class RightRotateArrayByDPlacesBruteForce {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        int k = 3;
        rotate(arr,k);
        System.out.println(Arrays.toString(arr));
    }

    private static void rotate(int[] arr, int k) {
        int n = arr.length;
        k = k % n;

        int[] temp = new int[n];

        int index = 0;
        for (int i = n - k; i < n; i++){
            temp[index] = arr[i];
            index++;
        }

        for (int i = 0; i < n - k; i++){
            temp[index] = arr[i];
            index++;
        }

        for (int i = 0; i < n; i++){
            arr[i] = temp[i];
        }
    }
}
