package com.anil.src;

import java.util.Arrays;

//similar to count inversions.
public class ReversePairsOptimal {
    public static void main(String[] args) {
        int[] arr = {2,4,3,5,1};
        int ans = reversePairs(arr);
        System.out.println(ans);
    }

    private static int reversePairs(int[] arr) {
        int[] copy = Arrays.copyOf(arr,arr.length);//to not modify the array.
        return mergeSort(copy,0,copy.length - 1);
    }

    private static int mergeSort(int[] arr, int low, int high) {
        if (low >= high) return 0;

        int mid = low + (high - low) / 2;
        int count = 0;

        // Count in left half
        count += mergeSort(arr, low, mid);

        // Count in right half
        count += mergeSort(arr, mid + 1, high);

        // Count reverse pairs across halves
        count += countReversePairs(arr, low, mid, high);

        // Merge the two sorted halves
        merge(arr, low, mid, high);

        return count;
    }

    private static void merge(int[] arr, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];

        int left = low;
        int right = mid + 1;
        int k = 0;

        // Merge sorted halves
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp[k++] = arr[left++];
            } else {
                temp[k++] = arr[right++];//in count inversion we were doing the calculation here,
            }//bcs that's what was needed there.if left > right,we took the count and added the count
        }//in the merge. so no separate function was needed in that case. But here,we cannot be sure so we create a separate function and added its count,so the merge remains void.we could have also had
        //separate function in count inversion but would be redundant and the else would take care of it.

        // Copy remaining left half
        while (left <= mid) {
            temp[k++] = arr[left++];
        }

        // Copy remaining right half
        while (right <= high) {
            temp[k++] = arr[right++];
        }

        // Copy back to original array
        int index = 0;
        for (int i = low; i <= high; i++) {
            arr[i] = temp[index];
            index++;
        }
    }

    private static int countReversePairs(int[] arr, int low, int mid, int high) {
        int right = mid + 1;
        int count = 0;

        for (int i = low; i <= mid; i++) {
            // Move right pointer while condition holds
            while (right <= high && (long) arr[i] > 2L * arr[right]) {
                right++;
            }

            count += (right - (mid + 1));//this is outside the while loop and not inside bcs
            //You have found the boundary, and you are ready to count the entire "chunk" of valid numbers at once.
        }

        return count;
    }
}
