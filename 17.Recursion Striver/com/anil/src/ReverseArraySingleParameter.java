package com.anil.src;

import java.util.Arrays;

public class ReverseArraySingleParameter {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        reverse(arr,0);
        System.out.println(Arrays.toString(arr));
    }

    private static void reverse(int[] arr, int index) {
        if (index >= arr.length / 2){
            return;
        }

        swap(arr,index);
        reverse(arr,index + 1);
    }

    private static void swap(int[] arr, int index) {
        int temp = arr[index];
        arr[index] = arr[arr.length - index - 1];
        arr[arr.length - index - 1] = temp;
    }
}
