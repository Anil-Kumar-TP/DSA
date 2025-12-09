package com.anil.src;

import java.util.Arrays;

public class SelectionSortMinVersion {
    public static void main(String[] args) {
        int[] arr = {3,0,1,4,-1};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++){
            int startIndex = i;
            int minIndex = getMinIndex(arr,startIndex,arr.length - 1);
            swap(arr,startIndex,minIndex);
        }
    }

    private static void swap(int[] arr, int startIndex, int minIndex) {
        int temp = arr[minIndex];
        arr[minIndex] = arr[startIndex];
        arr[startIndex] = temp;
    }

    private static int getMinIndex(int[] arr, int startIndex, int last) {
        int min = startIndex;
        for (int i = startIndex; i <= last; i++){
            if (arr[i] < arr[min]){
                min = i;
            }
        }
        return min;
    }
}
