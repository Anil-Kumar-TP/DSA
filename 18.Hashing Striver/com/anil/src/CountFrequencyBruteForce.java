package com.anil.src;

public class CountFrequencyBruteForce {
    public static void main(String[] args) {
        int[] arr = {1,1,1,3,2,4,3,7};
        int n = arr.length;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++){
            if (visited[i]){
                continue;
            }
            int count = 1;
            for (int j = i + 1; j < n; j++){
                if (arr[i] == arr[j]){
                    visited[j] = true;
                    count++;
                }
            }

            System.out.println(arr[i] + " -> " + count);
        }
    }
}


//    We mark something visited only if it is a duplicate, not if it is the first time we see it.