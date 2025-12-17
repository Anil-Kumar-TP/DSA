package com.anil.src;

import java.util.Arrays;

public class SetMatrixZeroBetter {
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

        int[] rowMarker = new int[rows];
        int[] colMarker = new int[cols];

        for (int row = 0; row < rows; row++){
            for (int col = 0; col < cols; col++){
                if (arr[row][col] == 0){
                    rowMarker[row] = 1;
                    colMarker[col] = 1;
                }
            }
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (rowMarker[row] == 1 || colMarker[col] == 1){
                    arr[row][col] = 0;
                }
            }
        }
    }
}
