package com.anil.src;

import java.util.HashMap;
import java.util.Map;

public class HighestLowestFreqOptimal {
    public static void main(String[] args) {
        int[] arr = {10,5,10,15,10,5};

        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        int maxFreq = Integer.MIN_VALUE;
        int minFreq = Integer.MAX_VALUE;
        int maxElement = -1;
        int minElement = -1;

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            int element = entry.getKey();
            int count = entry.getValue();

            if (count > maxFreq) {
                maxFreq = count;
                maxElement = element;
            }

            if (count < minFreq) {
                minFreq = count;
                minElement = element;
            }
        }

        System.out.println("Highest frequency element: " + maxElement);
        System.out.println("Lowest frequency element: " + minElement);
    }
}
