package com.anil.src;

import java.util.Arrays;

public class RearrangeElementsBySignBruteForceOther {
    public static void main(String[] args) {
        int[] arr = {1,2,-4,-5};
        int[] ans = rearrange(arr);
        System.out.println(Arrays.toString(ans));
    }

    private static int[] rearrange(int[] arr) {
        int[] positives = new int[arr.length / 2];
        int[] negatives = new int[arr.length / 2];

        int positiveIndex = 0;
        int negativeIndex = 0;

        for (int i = 0; i < arr.length; i++){
            if (arr[i] > 0){
                positives[positiveIndex] = arr[i];
                positiveIndex++;
            }else {
                negatives[negativeIndex] = arr[i];
                negativeIndex++;
            }
        }

        int[] result = new int[arr.length];

        for (int i = 0; i < arr.length / 2; i++) {
            result[2 * i] = positives[i];
            result[2 * i + 1] = negatives[i];
        }

        return result;
    }
}
