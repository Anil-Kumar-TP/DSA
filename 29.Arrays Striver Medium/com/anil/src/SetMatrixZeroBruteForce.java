package com.anil.src;

import java.util.Arrays;

public class SetMatrixZeroBruteForce {
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

        for (int row = 0; row < rows; row++){
            for (int col = 0; col < cols; col++){
               if (arr[row][col] == 0){
                   //mark rows as -1.
                   for (int currentColumn = 0; currentColumn < cols; currentColumn++){
                       if (arr[row][currentColumn] != 0){
                           arr[row][currentColumn] = -1;
                       }
                   }
                   //mark cols as -1.
                   for (int currentRow = 0; currentRow < rows; currentRow++){
                       if (arr[currentRow][col] != 0){
                           arr[currentRow][col] = -1;
                       }
                   }
               }
            }
        }

        for (int row = 0; row < rows; row++){
            for (int col = 0; col < cols; col++){
                if (arr[row][col] == -1){
                    arr[row][col] = 0;
                }
            }
        }
    }
}
