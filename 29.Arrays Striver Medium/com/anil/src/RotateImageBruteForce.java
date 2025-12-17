package com.anil.src;

import java.util.Arrays;

public class RotateImageBruteForce {
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
        int n = arr.length; //here we are not using rows and cols unlike set matrix zero is bcs this only
        int[][] rotated = new int[n][n];//works on square matrix.in qstn it is mentioned n * n

        for (int row = 0; row < arr.length; row++){
            for (int col = 0; col < arr.length; col++){
                rotated[col][n - row - 1] = arr[row][col];
            }
        }

        //copy back bcs of void. if return type was int[][] just return the array
        for (int row = 0; row < arr.length; row++){
            for (int col = 0; col < arr.length; col++){
                arr[row][col] = rotated[row][col];
            }
        }
    }
}
