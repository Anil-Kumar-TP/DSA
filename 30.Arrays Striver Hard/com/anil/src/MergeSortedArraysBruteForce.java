package com.anil.src;

import java.util.Arrays;

public class MergeSortedArraysBruteForce {
    public static void main(String[] args) {
        int[] arr1 = {-5, -2, 4, 5,0,0,0}; //zeroes to help with printing.
        int[] arr2 = {-3, 1, 8};
        int m = 4;
        int n = 3;
        merge(arr1,m,arr2,n);
        System.out.println(Arrays.toString(arr1));
    }

    private static void merge(int[] arr1, int m, int[] arr2, int n) {
        int[] ans = new int[m + n];
        int left = 0;
        int right = 0;
        int index = 0;
        while (left < m && right < n){
            if (arr1[left] <= arr2[right]){
                ans[index] = arr1[left];
                left++;
                index++;
            }else {
                ans[index] = arr2[right];
                right++;
                index++;
            }
        }

        while (left < m){
            ans[index] = arr1[left];
            left++;
            index++;
        }

        while (right < n){
            ans[index] = arr2[right];
            right++;
            index++;
        }

        for (int i = 0; i < m + n; i++){
          arr1[i] = ans[i];
        }
    }
}
