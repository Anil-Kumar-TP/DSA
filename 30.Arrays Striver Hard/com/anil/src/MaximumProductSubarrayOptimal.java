package com.anil.src;

public class MaximumProductSubarrayOptimal {
    public static void main(String[] args) {
        int[] arr = {2,3,-2,4};
        int ans = maximumProduct(arr);
        System.out.println(ans);
    }

    private static int maximumProduct(int[] arr) {
        int prefixProduct = 1;
        int suffixProduct = 1;
        int maxProduct = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++){
            prefixProduct = prefixProduct * arr[i];
            suffixProduct = suffixProduct * arr[arr.length - i - 1];

            maxProduct = Math.max(maxProduct,Math.max(prefixProduct,suffixProduct));
        }
        return maxProduct;
    }
}

//At i = 0: prefixProduct = 2. Is this the best so far? Yes.
//
//        At i = 1: prefixProduct = 6. Is this better? Yes.
//
//        At i = 2: prefixProduct = -12. Is this better? No.
//
//        At i = 3: prefixProduct = -48. Is this better? No.
//
//If you only check at the finish line (outside the loop), the CPU says the answer is -48. By checking inside, you recorded the 6 while it was happening.