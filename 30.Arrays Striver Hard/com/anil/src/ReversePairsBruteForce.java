package com.anil.src;

public class ReversePairsBruteForce {
    public static void main(String[] args) {
        int[] arr = {2,4,3,5,1};
        int ans = reversePairs(arr);
        System.out.println(ans);
    }

    private static int reversePairs(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length - 1; i++){
            for (int j = i + 1; j < arr.length; j++){
                if (arr[i] > 2L * arr[j]){
                    count++;
                }
            }
        }
        return count;
    }
}
