package com.anil.src;

import java.util.Arrays;

//Dutch National Flag algorithm
//used in sort colors also
public class SortAnArrayOf0s1sAnd2sOptimal {
    public static void main(String[] args) {
        int[] arr = {1, 0, 2, 1, 0};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr) {
        int low = 0;
        int mid = 0;
        int high = arr.length - 1;

        while (mid <= high){
            if (arr[mid] == 0){
                swap(arr,low,mid);
                low++;
                mid++;
            }else if (arr[mid] == 1){
                mid++;
            }else {
                swap(arr,mid,high);
                high--;
            }
        }
    }

    private static void swap(int[] arr, int low, int mid) {
        int temp = arr[low];
        arr[low] = arr[mid];
        arr[mid] = temp;
    }
}
