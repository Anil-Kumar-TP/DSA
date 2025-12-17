package com.anil.src;

import java.util.Arrays;

public class RotateImageOptimal {
    public static void main(String[] args) {
        int[][] arr = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        rotateImage(arr);
        System.out.println(Arrays.deepToString(arr));
    }

    private static void rotateImage(int[][] arr) {
        //transpose
        for (int i = 0; i < arr.length - 1; i++){
            for (int j = i + 1; j < arr.length; j++){
                swap(arr,i,j);
            }
        }

        //reverse the rows.
        for (int i = 0; i < arr.length; i++){
            int left = 0;
            int right = arr.length - 1;
            while (left < right){ //cant use the swap reuse here as it will produce incorrect results.
                int temp = arr[i][left];
                arr[i][left] = arr[i][right];
                arr[i][right] = temp;
                left++;
                right--;
            }
        }
    }

    private static void swap(int[][] arr, int i, int j) {
        int temp = arr[i][j];
        arr[i][j] = arr[j][i];
        arr[j][i] = temp;
    }
}


//swap is only useful for transpose
//for reflection,you need to swap two arbitrary cells within the same row.