package com.anil.src;

import java.util.Arrays;

public class MergeSortInPlace {
    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};
        mergeSort(arr,0,arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void mergeSort(int[] arr, int start, int end) {
        if (start >= end){
            return;
        }
        int mid = start + (end - start) / 2;
        mergeSort(arr,start,mid);
        mergeSort(arr,mid + 1,end);
        merge(arr,start,mid,end);
    }

    private static void merge(int[] arr, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        int i = start;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= end){
            if (arr[i] <= arr[j]){
                temp[k] = arr[i];
                i++;
            }else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }

        while (i <= mid){
            temp[k] = arr[i];
            i++;
            k++;
        }

        while (j <= end){
            temp[k] = arr[j];
            j++;
            k++;
        }

        int tempIndex = 0;
        for (int x = start; x <= end; x++){
            arr[x] = temp[tempIndex];
            tempIndex++;
        }
    }
}


//
//✅ Starting point
//
//        We call:
//
//        mergeSort(arr, start = 0, end = 4)
//
//
//        The midpoint = (0 + 4) / 2 = 2
//
//        So we split into:
//
//        Left → mergeSort(0, 2)
//
//        Right → mergeSort(3, 4)
//
//        🌿 Let’s trace mergeSort(0, 2) first
//        ▶️ Call: mergeSort(0, 2)
//
//        mid = 1
//        Split:
//
//        mergeSort(0, 1)
//
//        mergeSort(2, 2)
//
//        🌿 Dive into mergeSort(0, 1)
//        ▶️ Call: mergeSort(0, 1)
//
//        mid = 0
//        Split:
//
//        mergeSort(0, 0)
//
//        mergeSort(1, 1)
//
//        🚩 Call: mergeSort(0, 0)
//
//        start == end → base case hit
//
//        ✔️ Immediately returns.
//        Nothing to merge.
//        Control returns to mergeSort(0,1) waiting for the right half.
//
//        🚩 Call: mergeSort(1, 1)
//
//        Base case again. Returns.
//
//        Now both halves done, so parent performs:
//
//        🔄 merge(0, 0, 1)
//
//        Left half: [5]
//        Right half: [4]
//
//        Merged → [4, 5]
//
//        Array becomes:
//
//        [4, 5, 3, 2, 1]
//
//
//        Control returns to mergeSort(0,2).
//
//        🌿 Now mergeSort(2, 2)
//        🚩 Call: mergeSort(2, 2)
//
//        Base case hit, returns.
//
//        No merge needed.
//
//        🔄 Now parent merge: merge(0, 1, 2)
//
//        Left sorted part: [4, 5]
//        Right part: [3]
//
//        Merge → [3, 4, 5]
//
//        Array becomes:
//
//        [3, 4, 5, 2, 1]
//
//
//        Control now returns to the very first call: mergeSort(0,4).
//
//        🌿 Now process the right half: mergeSort(3, 4)
//        ▶️ Call: mergeSort(3, 4)
//
//        mid = 3
//        Split:
//
//        mergeSort(3, 3)
//
//        mergeSort(4, 4)
//
//        🚩 mergeSort(3, 3)
//
//        Base case → return.
//
//        🚩 mergeSort(4, 4)
//
//        Base case → return.
//
//        🔄 merge(3, 3, 4)
//
//        Left: [2]
//        Right: [1]
//
//        Merged → [1, 2]
//
//        Array becomes:
//
//        [3, 4, 5, 1, 2]
//
//
//        Control returns to the first call again.
//
//        🌳 FINAL MERGE: merge(0, 2, 4)
//
//        Left: [3, 4, 5]
//        Right: [1, 2]
//
//        Merge result:
//
//        → [1, 2, 3, 4, 5]
//
//        Array becomes:
//
//        [1, 2, 3, 4, 5]
//
//        🎯 Now let’s show the Final Call Stack Flow in Order
//        📌 Going down (recursive calls):
//
//        mergeSort(0,4)
//
//        mergeSort(0,2)
//
//        mergeSort(0,1)
//
//        mergeSort(0,0) → returns
//
//        mergeSort(1,1) → returns
//
//        merge(0,0,1)
//
//        mergeSort(2,2) → returns
//
//        merge(0,1,2)
//
//        mergeSort(3,4)
//
//        mergeSort(3,3) → returns
//
//        mergeSort(4,4) → returns
//
//        merge(3,3,4)
//
//        merge(0,2,4)
//
//        📌 Coming up (unwinding):
//
//        mergeSort(0,0) returns upward
//
//        mergeSort(1,1) returns → merge happens
//
//        mergeSort(2,2) returns → merge happens
//
//        mergeSort(3,3) returns
//
//        mergeSort(4,4) returns → merge happens
//
//final merge happens in the topmost call
//
//        This is exactly how merge sort flows.