package com.anil.src;

import java.util.Arrays;

public class RearrangeElementsBySignBruteForce {
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

        int i = 0;
        int p = 0;
        int n = 0;

        while (p < positiveIndex && n < negativeIndex){
            result[i] = positives[p];
            i++;
            p++;

            result[i] = negatives[n];
            i++;
            n++;
        }

        return result;
    }
}
