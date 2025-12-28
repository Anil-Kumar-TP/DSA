package com.anil.src;

import java.util.Arrays;

public class MergeSortedArraysOptimal {
    public static void main(String[] args) {
        int[] arr1 = {-5, -2, 4, 5,0,0,0};
        int[] arr2 = {-3, 1, 8};
        int m = 4;
        int n = 3;
        merge(arr1,m,arr2,n);
        System.out.println(Arrays.toString(arr1));
    }

    private static void merge(int[] arr1, int m, int[] arr2, int n) {
        int length = m + n;
        int gap = (length / 2) + (length % 2);
        while (gap > 0){
            int left = 0;
            int right = left + gap;
            while (right < length){
                if (left < m && right >= m){
                    swapIfGreater(arr1,arr2,left,right - m);
                }else if (left >= m){
                    swapIfGreater(arr2,arr2,left - m,right - m);
                }else {
                    swapIfGreater(arr1,arr1,left,right);
                }
                left++;
                right++;
            }

            if (gap == 1){
                break;
            }

            gap = (gap / 2) + (gap % 2);
        }

        for (int i = 0; i < n; i++) {
            arr1[m + i] = arr2[i];
        }
    }

    private static void swapIfGreater(int[] arr1, int[] arr2, int index1, int index2) {
        if (arr1[index1] > arr2[index2]){
            int temp = arr1[index1];
            arr1[index1] = arr2[index2];
            arr2[index2] = temp;
        }
    }
}
