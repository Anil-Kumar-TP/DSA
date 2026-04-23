package com.anil.src;

public class CelebrityProblemOptimalGFG {
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

        int top = 0;
        int down = n - 1;

        while (top < down) {
            if (arr[top][down] == 1) {
                top++;
            } else if (arr[down][top] == 1) {
                down--;
            }else {
                top++;
                down--;
            }
        }

        if (top > down) {
            return -1;
        }

        for (int i = 0; i < n; i++){
            if (i == top) {
                continue;
            }

            //if either top knows someone or someone dont know top,not a celeb.
            if (arr[top][i] == 1 || arr[i][top] == 0) {
                return -1;
            }
        }

        return top;
    }
}
