package com.anil.src;

import java.util.Arrays;

public class InsertionSortRec {
    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};
        insertionSort(arr,1);
        System.out.println(Arrays.toString(arr));
    }

    private static void insertionSort(int[] arr, int index) {
        if (index >= arr.length){
            return;
        }
        insertionSortHelper(arr,index);

        insertionSort(arr,index + 1);

    }

    private static void insertionSortHelper(int[] arr, int j) {
        if (j == 0 || arr[j] > arr[j - 1]){
            return;
        }
        swap(arr,j,j - 1);

        insertionSortHelper(arr,j - 1);
    }

    private static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
