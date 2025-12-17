package com.anil.src;

public class CountSubArraySumEqualsKBruteForce {
    public static void main(String[] args) {
        int k = 6;
        int[] arr = {3,1,2,4};
        int ans = countSubarray(arr,k);
        System.out.println(ans);
    }

    private static int countSubarray(int[] arr, int k) {
        int count = 0;
        for (int i = 0; i < arr.length; i++){
            int sum = 0;
            for (int j = i; j < arr.length; j++){
                sum = sum + arr[j];

                if (sum == k){
                    count++;
                }
            }
        }
        return count;
    }
}
