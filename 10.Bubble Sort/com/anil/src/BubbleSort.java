package com.anil.src;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {3,1,7,0,2};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void bubbleSort(int[] arr) {
        boolean swapped;
        for (int i = 0; i < arr.length; i++){
            swapped = false;
            for (int j = 1; j < arr.length - i; j++){
                if (arr[j - 1] > arr[j]){
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped){
                break;
            }
        }
    }
}
