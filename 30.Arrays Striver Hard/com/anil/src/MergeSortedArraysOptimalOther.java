package com.anil.src;

import java.util.Arrays;

public class MergeSortedArraysOptimalOther {
    public static void main(String[] args) {
        int[] arr1 = {-5, -2, 4, 5,0,0,0};
        int[] arr2 = {-3, 1, 8};
        int m = 4;
        int n = 3;
        merge(arr1,m,arr2,n);
        System.out.println(Arrays.toString(arr1));
    }

    private static void merge(int[] arr1, int m, int[] arr2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (i >= 0 && j >= 0){
            if (arr1[i] > arr2[j]){
                arr1[k] = arr1[i];
                k--;
                i--;
            }else {
                arr1[k] = arr2[j];
                k--;
                j--;
            }
        }

        while (j >= 0){
            arr1[k] = arr2[j];
            k--;
            j--;
        }
    }
}


//Think like this:
//
//nums1 already owns the array
//
//nums2 is the guest
//
//If the guest still has items → you must seat them
//
//If only the owner’s items remain → they’re already seated
//
//That’s the asymmetry.
//
//        this is the reason why only j has leftover condition and not for i