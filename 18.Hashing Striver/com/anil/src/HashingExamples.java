package com.anil.src;

import java.util.*;

public class HashingExamples {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Character frequency example
        String s = readString(sc, "Enter a string (chars): ");
        Map<Character, Integer> charFreq = buildCharFrequency(s);
        processCharQueries(sc, charFreq);

        System.out.println("------------------------------------------------");

        // Word frequency example
        String text = readString(sc, "Enter a text (words separated by space): ");
        Map<String, Integer> wordFreq = buildWordFrequency(text);
        processWordQueries(sc, wordFreq);
    }

    // ---------- String Input ----------
    private static String readString(Scanner sc, String prompt) {
        System.out.print(prompt);
        return sc.nextLine();
    }

    // ---------- Character Frequency ----------
    private static Map<Character, Integer> buildCharFrequency(String str) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char ch : str.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }
        return freqMap;
    }

    private static void processCharQueries(Scanner sc, Map<Character, Integer> freqMap) {
        System.out.print("Enter number of character queries: ");
        int q = sc.nextInt();
        sc.nextLine(); // consume newline
        for (int i = 0; i < q; i++) {
            System.out.print("Enter character to check frequency: ");
            char ch = sc.nextLine().charAt(0);
            System.out.println("Frequency of '" + ch + "': " + freqMap.getOrDefault(ch, 0));
        }
    }

    // ---------- Word Frequency ----------
    private static Map<String, Integer> buildWordFrequency(String text) {
        Map<String, Integer> freqMap = new HashMap<>();
        String[] words = text.split("\\s+"); // split by whitespace
        for (String word : words) {
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }
        return freqMap;
    }

    private static void processWordQueries(Scanner sc, Map<String, Integer> freqMap) {
        System.out.print("Enter number of word queries: ");
        int q = sc.nextInt();
        sc.nextLine(); // consume newline
        for (int i = 0; i < q; i++) {
            System.out.print("Enter word to check frequency: ");
            String word = sc.nextLine();
            System.out.println("Frequency of \"" + word + "\": " + freqMap.getOrDefault(word, 0));
        }
    }
}
