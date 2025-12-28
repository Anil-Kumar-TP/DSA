package com.anil.src;

import java.util.Arrays;

public class MissingAndRepeatingNumbersOptimal {
    public static void main(String[] args) {
        int[] arr = {3, 5, 4, 1, 1};
        int[] ans = missingAndRepeating(arr);
        System.out.println(Arrays.toString(ans));
    }

    private static int[] missingAndRepeating(int[] arr) {
        int n = arr.length;

        long expectedSum = (long) n * (n + 1) / 2;
        long expectedSquareSum = n * (n + 1) * (2L * n + 1) / 6;

        long actualSum = 0;
        long actualSquareSum = 0;

        for (int num : arr){
            actualSum = actualSum + num;
            actualSquareSum = actualSquareSum + (long) num * num;
        }

        long diffSum = actualSum - expectedSum;               // X - Y
        long diffSquareSum = actualSquareSum - expectedSquareSum; // X² - Y²

        long sumOfNumbers = diffSquareSum / diffSum;          // X + Y

        long repeating = (diffSum + sumOfNumbers) / 2;
        long missing = repeating - diffSum;

        return new int[]{(int) repeating, (int) missing};
    }
}
