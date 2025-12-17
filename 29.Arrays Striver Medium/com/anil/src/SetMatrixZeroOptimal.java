package com.anil.src;

import java.util.Arrays;

public class SetMatrixZeroOptimal {
    public static void main(String[] args) {
        int[][] arr = {
                {1,1,1},
                {1,0,1},
                {1,1,1}
        };
        setZeroes(arr);
        System.out.println(Arrays.deepToString(arr));
    }

    private static void setZeroes(int[][] arr) {
        int rows = arr.length;
        int cols = arr[0].length;

        int firstRow = 0;
        int firstCol = 0;

        for (int col = 0; col < cols; col++){
            if (arr[0][col] == 0){
                firstRow = 1;
                break;
            }
        }

        for (int row = 0; row < rows; row++){
            if (arr[row][0] == 0){
                firstCol = 1;
                break;
            }
        }

        // Use first row & column as markers
        for (int row = 1; row < rows; row++){
            for (int col = 1; col < cols; col++){
                if (arr[row][col] == 0){
                    arr[row][0] = 0;
                    arr[0][col] = 0;
                }
            }
        }

        // Apply zeroes using markers
        for (int row = 1; row < rows; row++){
            for (int col = 1; col < cols; col++){
                if (arr[row][0] == 0 || arr[0][col] == 0){
                    arr[row][col] = 0;
                }
            }
        }

        if (firstRow == 1){
            for (int col = 0; col < cols; col++){
                arr[0][col] = 0;
            }
        }

        if (firstCol == 1){
            for (int row = 0; row < rows; row++){
                arr[row][0] = 0;
            }
        }
    }
}
