package com.anil.src;

public class NumberAppearsOnceOptimal {
    public static void main(String[] args) {
        int[] arr = {1,1,2,3,3,4,4};
        int ans = numbers(arr);
        System.out.println(ans);
    }

    private static int numbers(int[] arr) {
        int xor = 0;
        for (int num : arr){
            xor = xor ^ num;
        }
        return xor;
    }
}
