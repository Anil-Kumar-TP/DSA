package com.anil.src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeOverlappingIntervalsBruteForce {
    public static void main(String[] args) {
        int[][] arr = {
                {1,3},
                {2,6},
                {8,9},
                {9,11},
                {8,10},
                {2,4},
                {15,18},
                {16,17}
        };
        int[][] ans = merge(arr);
        System.out.println(Arrays.deepToString(ans));
    }

    private static int[][] merge(int[][] arr) {
        int n = arr.length;
        Arrays.sort(arr,(a,b) -> a[0] - b[0]);

        boolean[] visited = new boolean[n];
        List<int[]> result = new ArrayList<>();

        for (int i = 0; i < n; i++){
            if (visited[i]){
                continue;
            }

            int start = arr[i][0];
            int end = arr[i][1];

            visited[i] = true;

            for (int j = 0; j < n; j++){
                if (visited[j]){
                    continue;
                }

                if (arr[j][0] <= end && arr[j][1] >= start){
                    start = Math.min(start,arr[j][0]);
                    end = Math.max(end,arr[j][1]);
                    visited[j] = true;
                }
            }

            result.add(new int[]{start,end});
        }

        return result.toArray(new int[result.size()][]);
    }
}