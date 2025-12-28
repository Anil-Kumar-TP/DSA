package com.anil.src;

import java.util.Arrays;

public class MergeSortedArraysBetter {
    public static void main(String[] args) {
        int[] arr1 = {-5, -2, 4, 5,0,0,0};
        int[] arr2 = {-3, 1, 8};
        int m = 4;
        int n = 3;
        merge(arr1,m,arr2,n);
        System.out.println(Arrays.toString(arr1));
    }

    private static void merge(int[] arr1, int m, int[] arr2, int n) {
        int left = m - 1;
        int right = 0;
        while (left >= 0 && right < n){
            if (arr1[left] > arr2[right]){
                int temp = arr1[left];
                arr1[left] = arr2[right];
                arr2[right] = temp;
                left--;
                right++;
            }else {
                break;
            }
        }

        Arrays.sort(arr1,0,m);
        Arrays.sort(arr2);

        for (int i = 0; i < n; i++) {
            arr1[m + i] = arr2[i];
        }
    }
}
