package com.anil.src;

public class CelebrityProblemBruteForceGFG {
    public static void main(String[] args) {
        int[][] arr = {
                {0, 1, 1, 0},
                {0, 0, 0, 0},
                {1, 1, 0, 0},
                {0, 1, 1, 0}
        };
        int ans = celebrity(arr);
        System.out.println(ans);
    }

    private static int celebrity(int[][] arr) {
        int n = arr.length;

        int[] knowme = new int[n];
        int[] iknow = new int[n];

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (arr[i][j] == 1){
                    iknow[i]++;
                    knowme[j]++;
                }
            }
        }

        for (int i = 0; i < n; i++){
            if (knowme[i] == n - 1 && iknow[i] == 0){
                return i;
            }
        }

        return -1;
    }
}
