package com.anil.src;

import java.util.Scanner;

public class HashingOther {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = readArray(sc);
        int maxValue = findMax(arr);
        int[] freq = buildFrequency(arr, maxValue);
        handleQueries(sc, freq, maxValue);
    }

    private static int[] readArray(Scanner sc) {
        System.out.println("Enter array size:");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        return arr;
    }

    private static int findMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int value : arr) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

    private static int[] buildFrequency(int[] arr, int maxValue) {
        int[] freq = new int[maxValue + 1];

        for (int value : arr) {
            freq[value]++;
        }
        return freq;
    }

    private static void handleQueries(Scanner sc, int[] freq, int maxValue) {
        System.out.println("Enter number of queries:");
        int q = sc.nextInt();

        while (q-- > 0) {
            System.out.println("Enter number to find frequency:");
            int x = sc.nextInt();

            if (x < 0 || x > maxValue) {
                System.out.println("Frequency = 0");
            } else {
                System.out.println("Frequency = " + freq[x]);
            }
        }
    }
}

//q-- > 0 is same as q > 0 and later q--
