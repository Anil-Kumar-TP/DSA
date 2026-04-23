package com.anil.src;

import java.util.Arrays;
import java.util.Stack;

public class NextSmallerElementToRightOptimal {
    public static void main(String[] args) {
        int[] arr = {4, 5, 2, 10, 8};
        int[] ans = nextSmallerToRight(arr);
        System.out.println(Arrays.toString(ans));
    }

    private static int[] nextSmallerToRight(int[] arr) {
        int[] result = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = arr.length - 1; i >= 0; i--){
            while (!stack.isEmpty() && stack.peek() >= arr[i]){
                stack.pop();
            }

            result[i] = stack.isEmpty() ? -1 : stack.peek();

            stack.push(arr[i]);
        }

        return result;
    }
}
