package com.anil.src;

public class MaximumProductSubarrayBruteForce {
    public static void main(String[] args) {
        int[] arr = {2,3,-2,4};
        int ans = maximumProduct(arr);
        System.out.println(ans);
    }

    private static int maximumProduct(int[] arr) {
        int maxProduct = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++){
            for (int j = i; j < arr.length; j++){
                int product = 1;
                for (int k = i; k <= j; k++){
                    product = product * arr[k];
                }
                if (product > maxProduct){
                    maxProduct = product;
                }
            }
        }
        return maxProduct;
    }
}
