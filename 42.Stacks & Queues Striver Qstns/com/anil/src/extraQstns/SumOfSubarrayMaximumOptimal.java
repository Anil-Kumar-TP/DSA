package com.anil.src.extraQstns;

import java.util.Stack;

public class SumOfSubarrayMaximumOptimal {
    public static void main(String[] args) {
        int[] arr = {3,1,2,4};
        int ans = sumOfSubarrayMaximum(arr);
        System.out.println(ans);
    }

    public static int sumOfSubarrayMaximum(int[] arr) {
        int n = arr.length;

        int[] nge = findNGE(arr);
        int[] pgee = findPGEE(arr);

        int mod = (int)1e9 + 7;
        int sum = 0;

        for (int i = 0; i < n; i++){
            int left = i - pgee[i];
            int right = nge[i] - i;

            long freq = (long) left * right;
            int contribution = (int) ((freq * arr[i]) % mod);

            sum = (sum + contribution) % mod;
        }

        return sum;
    }

    private static int[] findPGEE(int[] arr) {
        int[] result = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < arr.length; i++){
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]){
                stack.pop();
            }

            result[i] = !stack.isEmpty() ? stack.peek() : -1;

            stack.push(i);
        }

        return result;
    }

    private static int[] findNGE(int[] arr) {
        int[] result = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = arr.length - 1; i >= 0; i--){
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]){
                stack.pop();
            }

            result[i] = !stack.isEmpty() ? stack.peek() : arr.length;

            stack.push(i);
        }

        return result;
    }
}
