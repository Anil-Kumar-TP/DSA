package com.anil.src;

public class MissingNumberBruteForce {
    public static void main(String[] args) {
        int[] arr = {1,2,4,5};
        int n = 5;
        int ans = missing(arr,n);
        System.out.println(ans);
    }

    private static int missing(int[] arr,int n) {
        for (int i = 1; i <= n; i++){
            boolean found = false;
            for (int num : arr){
                if (i == num){
                    found = true;
                    break;
                }
            }
            if (!found){
                return i;
            }
        }
        return -1;
    }
}