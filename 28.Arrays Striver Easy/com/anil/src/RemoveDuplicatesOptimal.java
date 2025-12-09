package com.anil.src;

import java.util.Arrays;

public class RemoveDuplicatesOptimal {
    public static void main(String[] args) {
        int[] arr = {1,1,1,2,2,3,3};
        int count = duplicates(arr);
        System.out.println(count);
        System.out.println(Arrays.toString(arr));
    }

    private static int duplicates(int[] arr) {
        int i = 0;
        for (int j = 1; j < arr.length; j++){
            if (arr[j] != arr[i]){
                arr[i + 1] = arr[j];
                i++;
            }
        }

        for (int k = i + 1; k < arr.length; k++){
            arr[k] = -1;
        }

        return i + 1;
    }
}
