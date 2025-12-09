package com.anil.src;

public class MissingNumberOptimalXorSingleLoop {
    public static void main(String[] args) {
        int[] arr = {1,2,4,5};
        int n = 5;
        int ans = missing(arr,n);
        System.out.println(ans);
    }

    private static int missing(int[] arr, int n) {
        int xor = 0;
        for (int i = 0; i < arr.length; i++){
            xor = xor ^ arr[i];//actual
            xor = xor ^ (i + 1);//expected
        }
        xor = xor ^ n;

        return xor;
    }
}
