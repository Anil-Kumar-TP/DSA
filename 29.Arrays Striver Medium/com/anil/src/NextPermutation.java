package com.anil.src;

import java.util.Arrays;

public class NextPermutation {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        nextPermutation(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void nextPermutation(int[] arr) {
        int index = -1;
        for (int i = arr.length - 2; i >= 0; i--){
            if (arr[i] < arr[i + 1]){
                index = i;
                break;
            }
        }

        if (index == -1){
            reverse(arr,0,arr.length - 1);
        }

        for (int i = arr.length - 1; i >= index; i--){
            if (arr[i] > arr[index]){
                swap(arr,i,index);
                break;
            }
        }

        reverse(arr,index + 1,arr.length - 1);
    }

    private static void reverse(int[] arr, int start, int end) {
        while (start < end){
            swap(arr,start,end);
            start++;
            end--;
        }
    }

    private static void swap(int[] arr, int start, int end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }
}

//
//Step 0: Initial array
//arr = [1, 3, 5, 4, 2]
//
//Step 1: Find the pivot
//
//Loop from i = arr.length - 2 = 3 down to 0:
//
//i = 3: arr[3] = 4, arr[4] = 2 → 4 < 2? ❌
//
//i = 2: arr[2] = 5, arr[3] = 4 → 5 < 4? ❌
//
//i = 1: arr[1] = 3, arr[2] = 5 → 3 < 5? ✅ Pivot found at index = 1
//
//Pivot = 3, suffix = [5, 4, 2]
//
//
//
//
//Step 2: Find the element in suffix to swap with pivot
//
//Loop from i = arr.length - 1 = 4 down to index = 1:
//
//i = 4: arr[4] = 2 → 2 > 3? ❌
//
//i = 3: arr[3] = 4 → 4 > 3? ✅ Swap pivot (3) with 4
//
//Array after swap:
//
//arr = [1, 4, 5, 3, 2]
//
//
//Step 3: Reverse the suffix (elements after pivot index)
//
//Suffix is from index + 1 = 2 to end 4 → [5, 3, 2]
//
//Reverse [5, 3, 2] → [2, 3, 5]
//
//Array after reversing suffix:
//
//arr = [1, 4, 2, 3, 5]
//
//
//        ✅ This is the next permutation.