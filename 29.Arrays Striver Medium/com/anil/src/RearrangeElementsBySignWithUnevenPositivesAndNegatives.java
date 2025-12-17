package com.anil.src;

import java.util.Arrays;

public class RearrangeElementsBySignWithUnevenPositivesAndNegatives {
    public static void main(String[] args) {
        int[] arr = {1,2,-4,-5,8,9};
        int[] ans = rearrange(arr);
        System.out.println(Arrays.toString(ans));
    }

    private static int[] rearrange(int[] arr) {
        int[] positives = new int[arr.length];
        int[] negatives = new int[arr.length];

        int positiveIndex = 0;
        int negativeIndex = 0;

        for (int num : arr) {
            if (num > 0) {
                positives[positiveIndex] = num;
                positiveIndex++;
            } else {
                negatives[negativeIndex] = num;
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

        while (p < positiveIndex){
            result[i] = positives[p];
            i++;
            p++;
        }

        while (n < negativeIndex){
            result[i] = negatives[n];
            i++;
            n++;
        }

        return result;
    }
}
