package com.anil.src;

public class MissingNumberOptimalSum {
    public static void main(String[] args) {
        int[] arr = {1,2,4,5};
        int n = 5;
        int ans = missing(arr,n);
        System.out.println(ans);
    }

    private static int missing(int[] arr, int n) {
        int sum = n * (n + 1) / 2;
        int sum2 = 0;
        for (int num : arr){
            sum2 = sum2 + num;
        }

        return sum - sum2;
    }
}
