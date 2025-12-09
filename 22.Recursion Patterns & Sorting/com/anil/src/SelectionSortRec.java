package com.anil.src;

import java.util.Arrays;

public class SelectionSortRec {
    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};
        selectionSort(arr,arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void selectionSort(int[] arr,int lastIndex) {
        if (lastIndex <= 0){
            return;
        }
        int maxIndex = findMaxIndex(arr,0,lastIndex);
        swap(arr,maxIndex,lastIndex);

        selectionSort(arr,lastIndex - 1);
    }

    private static void swap(int[] arr, int maxIndex, int lastIndex) {
        int temp = arr[maxIndex];
        arr[maxIndex] = arr[lastIndex];
        arr[lastIndex] = temp;
    }

    private static int findMaxIndex(int[] arr, int start, int lastIndex) {
        int max = start;
        for (int i = start; i <= lastIndex; i++){
            if (arr[i] > arr[max]){
                max = i;
            }
        }
        return max;
    }
}

//
//    You pass an index, not a size.
//
//        lastIndex itself is the index of the last element in the unsorted region.
//
//        Let’s check what each value means:
//
//        lastIndex = 1 → unsorted portion = arr[0] and arr[1] → 2 elements → must run
//
//        lastIndex = 0 → unsorted portion = arr[0] → 1 element → sorted → stop
//
//        So we must stop only when lastIndex == 0.
//
//        If you write:
//
//        if (lastIndex <= 1) return;
//
//
//        ⚠️ You are stopping when lastIndex = 1, which means:
//
//        You skip the final required comparison between arr[0] and arr[1].
//
//        And the array ends up not sorted.
//
//        🔍 Visual demo
//
//        Take arr = [3, 1, 2]
//
//        Case 1: correct base case
//
//        lastIndex = 2 → find max in [0..2]
//        lastIndex = 1 → find max in [0..1]
//        lastIndex = 0 → stop
//
//        👉 Works.
//
//        Case 2: your version (lastIndex <= 1)
//
//        lastIndex = 2 → run
//        lastIndex = 1 → STOP ❌
//
//        You skipped comparing 3 and 1 → array stays partially unsorted.