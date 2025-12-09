package com.anil.src;

import java.util.Scanner;

public class StringLowerCaseHashing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = readString(sc);
        int[] freq = buildFrequency(str);
        processQueries(sc,freq);
    }

    private static String readString(Scanner sc) {
        System.out.println("Enter a lowercase string");
        return sc.next();
    }

    private static int[] buildFrequency(String str) {
        int[] freq = new int[26];
        for (int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            int index = ch - 'a';
            freq[index]++;
        }
        return freq;
    }

    private static void processQueries(Scanner sc, int[] freq) {
        System.out.println("Enter number of queries");
        int q = sc.nextInt();
        for (int i = 0; i < q; i++){
            System.out.println("Enter a lowercase character");
            char ch = sc.next().charAt(0);
            int index = ch - 'a';

            if (index < 0 || index > 25) {
                System.out.println("Not a lowercase letter");
            } else {
                System.out.println("Frequency = " + freq[index]);
            }
        }
    }
}
