package com.anil.src;

import java.util.Arrays;

public class SortAnArrayOf0s1sAnd2sBruteForce {
    public static void main(String[] args) {
        int[] arr = {1, 0, 2, 1, 0};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr) {
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;

        for (int num : arr){
            if (num == 0){
                count0++;
            }else if (num == 1){
                count1++;
            }else {
                count2++;
            }
        }

        int index = 0;
        for (int i = 0; i < count0; i++){
            arr[index] = 0;
            index++;
        }

        for (int i = 0; i < count1; i++){
            arr[index] = 1;
            index++;
        }

        for (int i = 0; i < count2; i++){
            arr[index] = 2;
            index++;
        }
    }
}
