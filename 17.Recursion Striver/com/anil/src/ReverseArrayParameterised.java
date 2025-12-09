package com.anil.src;

import java.util.Arrays;

public class ReverseArrayParameterised {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        reverse(arr,0,arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void reverse(int[] arr, int start, int end) {
        if (start >= end){
            return;
        }
        swap(arr,start,end);
        reverse(arr,start + 1,end - 1);
    }

    private static void swap(int[] arr, int start, int end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }
}
