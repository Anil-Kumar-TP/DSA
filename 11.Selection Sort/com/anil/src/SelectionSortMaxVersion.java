package com.anil.src;

import java.util.Arrays;

public class SelectionSortMaxVersion {
    public static void main(String[] args) {
        int[] arr = {3,0,1,4,-1};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++){
            int lastIndex = arr.length - i - 1;
            int maxIndex = getMaxIndex(arr,0,lastIndex);
            swap(arr,maxIndex,lastIndex);
        }
    }

    private static void swap(int[] arr, int maxIndex, int lastIndex) {
        int temp = arr[maxIndex];
        arr[maxIndex] = arr[lastIndex];
        arr[lastIndex] = temp;
    }

    private static int getMaxIndex(int[] arr, int start, int last) {
        int max = start;
        for (int i = start; i <= last; i++){
            if (arr[i] > arr[max]){
                max = i;
            }
        }
        return max;
    }
}
