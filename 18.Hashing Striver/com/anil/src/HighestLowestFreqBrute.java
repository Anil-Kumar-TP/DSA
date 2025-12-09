package com.anil.src;

public class HighestLowestFreqBrute {
    public static void main(String[] args) {
        int[] arr = {10,5,10,15,10,5};
        findHighLowBrute(arr);
    }

    public static void findHighLowBrute(int[] arr) {
        int n = arr.length;
        boolean[] visited = new boolean[n];

        int maxFreq = Integer.MIN_VALUE;
        int minFreq = Integer.MAX_VALUE;
        int maxElement = -1;
        int minElement = -1;

        for (int i = 0; i < n; i++) {

            if (visited[i]) continue;

            int count = 1;

            for (int j = i + 1; j < n; j++) {
                if (arr[i] == arr[j]) {
                    visited[j] = true;
                    count++;
                }
            }

            // update highest
            if (count > maxFreq) {
                maxFreq = count;
                maxElement = arr[i];
            }

            // update lowest
            if (count < minFreq) {
                minFreq = count;
                minElement = arr[i];
            }
        }

        System.out.println("Highest frequency element: " + maxElement);
        System.out.println("Lowest frequency element: " + minElement);
    }
}
