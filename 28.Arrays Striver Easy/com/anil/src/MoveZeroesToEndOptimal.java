package com.anil.src;

import java.util.Arrays;

public class MoveZeroesToEndOptimal {
    public static void main(String[] args) {
        int[] arr = {1 ,0 ,2 ,3 ,0 ,4 ,0 ,1};
        move(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void move(int[] arr) {
        int j = -1;
        for (int i = 0; i < arr.length; i++){
            if (arr[i] == 0){
                j = i;//j will have the first zero.
                break;
            }
        }

        //no zero found.
        if (j == -1){
            return;
        }

        // Start from the next index of first zero
        for (int i = j + 1; i < arr.length; i++){
            if (arr[i] != 0){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++; //move j to next zero.
            }
        }
    }
}
