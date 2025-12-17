package com.anil.src;

import java.util.Arrays;

public class RearrangeElementsBySignOptimal {
    public static void main(String[] args) {
        int[] arr = {1,2,-4,-5};
        int[] ans = rearrange(arr);
        System.out.println(Arrays.toString(ans));
    }

    private static int[] rearrange(int[] arr) {
        int[] result = new int[arr.length];

        int positiveIndex = 0;
        int negativeIndex = 1;

        for (int i = 0; i < arr.length; i++){
            if (arr[i] > 0){
                result[positiveIndex] = arr[i];
                positiveIndex = positiveIndex + 2;
            }else {
                result[negativeIndex] = arr[i];
                negativeIndex = negativeIndex + 2;
            }
        }
        return result;
    }
}
