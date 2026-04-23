package com.anil.src;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementCircularOptimal {
    public static void main(String[] args) {
        int[] arr = {1,2,1};
        int[] ans = nextGreaterElement(arr);
        System.out.println(Arrays.toString(ans));
    }

    private static int[] nextGreaterElement(int[] arr) {
        int[] result = new int[arr.length];
        int n = arr.length;
        Arrays.fill(result,-1);

        Stack<Integer> stack = new Stack<>();

        for (int i = 2 * n - 1; i >= 0; i--){
            int index = i % n;

            while (!stack.isEmpty() && arr[index] >= stack.peek()){
                stack.pop();
            }

            if (i < n){
                if (!stack.isEmpty()) {
                    result[index] = stack.peek();
                }
            }

            stack.push(arr[index]);
        }

        return result;
    }
}