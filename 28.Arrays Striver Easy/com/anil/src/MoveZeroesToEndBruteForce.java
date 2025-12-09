package com.anil.src;

import java.util.Arrays;

public class MoveZeroesToEndBruteForce {
    public static void main(String[] args) {
        int[] arr = {1 ,0 ,2 ,3 ,0 ,4 ,0 ,1};
        move(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void move(int[] arr) {
        int n = arr.length;
        int[] temp = new int[n];

        int index = 0;
        for (int i = 0; i < n; i++){
            if (arr[i] != 0){
                temp[index] = arr[i];
                index++;
            }
        }

        for (int i = 0; i < n; i++){
            arr[i] = temp[i];
        }
    }
}
