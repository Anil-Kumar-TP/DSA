package com.anil.src;

import java.util.Scanner;

public class StringMixedCaseHashing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = readString(sc);
        int[] freq = buildFrequency(str);
        processQueries(sc, freq);
    }

    private static String readString(Scanner sc) {
        System.out.println("Enter a string (lowercase + uppercase):");
        return sc.next();
    }

    private static int[] buildFrequency(String str) {
        int[] freq = new int[256];  // ASCII range

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            freq[ch]++;  // direct mapping using ASCII
        }

        return freq;
    }

    private static void processQueries(Scanner sc, int[] freq) {
        System.out.println("Enter number of queries:");
        int q = sc.nextInt();

        for (int i = 0; i < q; i++) {
            System.out.println("Enter a character:");
            char ch = sc.next().charAt(0);

            if ((int) ch < 0 || (int) ch > 255) {
                System.out.println("Character out of ASCII range");
            } else {
                System.out.println("Frequency = " + freq[ch]);
            }
        }
    }
}
