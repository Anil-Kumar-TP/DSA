package com.anil.src;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};
        int[] ans = mergeSort(arr);
        System.out.println(Arrays.toString(ans));
    }

    private static int[] mergeSort(int[] arr) {
        if (arr.length == 1){
            return arr;
        }

        int mid = arr.length / 2;

        int[] left = mergeSort(Arrays.copyOfRange(arr,0,mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr,mid,arr.length));

        return merge(left,right);
    }

    private static int[] merge(int[] left, int[] right) {
        int[] mix = new int[left.length + right.length];
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < left.length && j < right.length){
            if (left[i] < right[j]){
                mix[k] = left[i];
                i++;
            }else {
                mix[k] = right[j];
                j++;
            }
            k++;
        }

        while (i < left.length){
            mix[k] = left[i];
            i++;
            k++;
        }

        while (j < right.length){
            mix[k] = right[j];
            j++;
            k++;
        }

        return mix;
    }

}



//    mergeSort([5,4,3,2,1])
//    |
//            |-- mergeSort([5,4])
//            |        |
//            |        |-- mergeSort([5]) → [5]
//            |        |-- mergeSort([4]) → [4]
//            |        |-- merge([5],[4]) → [4,5]
//            |
//            |-- mergeSort([3,2,1])
//            |
//            |-- mergeSort([3]) → [3]
//            |-- mergeSort([2,1])
//            |        |
//            |        |-- mergeSort([2]) → [2]
//            |        |-- mergeSort([1]) → [1]
//            |        |-- merge([2],[1]) → [1,2]
//            |
//            |-- merge([3],[1,2]) → [1,2,3]
//
//            |-- merge([4,5],[1,2,3]) → [1,2,3,4,5]
