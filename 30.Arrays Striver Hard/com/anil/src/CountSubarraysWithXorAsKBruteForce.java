package com.anil.src;

public class CountSubarraysWithXorAsKBruteForce {
    public static void main(String[] args) {
        int[] arr = {4, 2, 2, 6, 4};
        int k = 6;
        int ans = countSubarrays(arr,k);
        System.out.println(ans);
    }

    private static int countSubarrays(int[] arr, int k) {
        int count = 0;
        for (int i = 0; i < arr.length; i++){
            for (int j = i; j < arr.length; j++){
                int xor = 0;
                for (int l = i; l <= j; l++){
                    xor = xor ^ arr[l];
                }

                if (xor == k){
                    count++;
                }
            }
        }
        return count;
    }
}
