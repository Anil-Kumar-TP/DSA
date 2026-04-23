package com.anil.src;

import java.util.Stack;

public class SumOfSubarrayMinimumOptimal {
    public static void main(String[] args) {
        int[] arr = {3,1,2,4};
        int ans = sumOfSubarrayMinimum(arr);
        System.out.println(ans);
    }

    static int sumOfSubarrayMinimum(int[] arr) {
        int n = arr.length;

        int[] nse = findNSE(arr);
        int[] psee = findPSEE(arr);

        int mod = (int)1e9 + 7;
        int sum = 0;

        for (int i = 0; i < n; i++){
            int left = i - psee[i];
            int right = nse[i] - i;

            long freq = (long) left * right;
            int contribution = (int) ((freq * arr[i]) % mod);

            sum = (sum + contribution) % mod;
        }

        return sum;
    }

    private static int[] findPSEE(int[] arr) {
        int[] result = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < arr.length; i++){
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]){
                stack.pop();
            }

            result[i] = !stack.isEmpty() ? stack.peek() : -1;

            stack.push(i);
        }

        return result;
    }

    private static int[] findNSE(int[] arr) {
        int[] result = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = arr.length - 1; i >= 0; i--){
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]){
                stack.pop();
            }

            result[i] = !stack.isEmpty() ? stack.peek() : arr.length;

            stack.push(i);
        }

        return result;
    }
}
