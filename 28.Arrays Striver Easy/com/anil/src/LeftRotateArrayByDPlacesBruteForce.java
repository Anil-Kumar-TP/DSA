package com.anil.src;

import java.util.Arrays;

public class LeftRotateArrayByDPlacesBruteForce {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        int k = 3;
        rotate(arr,k);
        System.out.println(Arrays.toString(arr));
    }

    private static void rotate(int[] arr, int k) {
        int n = arr.length;
        k = k % n;//like if the rotation k is said to be done 20 times and k is 7, it is 7 + 7 + 6
//so effectively 2 full rotation which do not change anything + 6 rotation.
        int[] temp = new int[n];

        // copy from k to end
        int index = 0;
        for (int i = k; i < n; i++){
            temp[index] = arr[i];
            index++;
        }

        // copy from 0 to k-1
        for (int i = 0; i < k; i++){
            temp[index] = arr[i];
            index++;
        }

        // copy back
        for (int i = 0; i < n; i++){
            arr[i] = temp[i];
        }
    }
}
