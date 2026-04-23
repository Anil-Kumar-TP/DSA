package com.anil.src;

import java.util.Arrays;
import java.util.Stack;

public class NearestSmallerElementToLeftOptimal {
    public static void main(String[] args) {
        int[] arr = {4,5,2,10,8};
        int[] ans = nearestSmallerToLeft(arr);
        System.out.println(Arrays.toString(ans));
    }

    private static int[] nearestSmallerToLeft(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[arr.length];

        for (int i = 0; i < arr.length; i++){
            while (!stack.isEmpty() && stack.peek() >= arr[i]){
                stack.pop();
            }

            if (stack.isEmpty()) {
                result[i] = -1;
            }else {
                result[i] = stack.peek();
            }

            stack.push(arr[i]);
        }

        return result;
    }
}
