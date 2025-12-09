package com.anil.src;

import java.util.Arrays;

public class BubbleSortRec{
    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};
        bubbleSort(arr,arr.length);
        System.out.println(Arrays.toString(arr));
    }

    private static void bubbleSort(int[] arr,int n) {
        if (n <= 1){
            return;
        }
        boolean swapped = false;
        for (int j = 1; j <= n - 1; j++){
            if (arr[j - 1] > arr[j]){
                int temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
                swapped = true;
            }
        }
        if (!swapped){
            return;
        }
        bubbleSort(arr,n - 1);
    }
}



//    You pass size, not an index.
//
//        n = 1 → only one element → sorted → stop.
//
//        n = 2 → two elements → you must still compare → so your recursion runs when n = 2.
//
//        That’s why bubble sort uses:
//
//        if (n <= 1) return;
//
//
//        This runs the recursion for n = 2, and stops at n = 1.
//
//        Perfect.
