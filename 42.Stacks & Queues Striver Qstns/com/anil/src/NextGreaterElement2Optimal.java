package com.anil.src;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement2Optimal {
    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 4};
        int[] ans = nextGreater(arr);
        System.out.println(Arrays.toString(ans));
    }

    //storing indices in stack.

    private static int[] nextGreater(int[] arr) {
        int[] result = new int[arr.length];
        Arrays.fill(result,-1);

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < arr.length; i++){
            while (!stack.isEmpty() && arr[i] > arr[stack.peek()]){
                int index = stack.pop();
                result[index] = arr[i];
            }
            stack.push(i);
        }

        return result;
    }
}

//
//Input Array: arr = [4, 5, 2, 10]
//Initialization: * result = [-1, -1, -1, -1] (Everything starts as -1)
//
//stack = [] (Empty waiting room)
//
//Step-by-Step Execution
//1. i = 0 (Value: 4)
//Stack Check: Empty.
//
//        Action: Push index 0.
//
//State: stack = [0]. result = [-1, -1, -1, -1]
//
//        2. i = 1 (Value: 5)
//Stack Check: stack.peek() is index 0. Value arr[0] is 4.
//
//Comparison: Is 4 < 5? Yes!
//
//pop index 0.
//
//result[0] = 5. (The 4 at index 0 found its next greater!)
//
//Stack Check: Empty now.
//
//Action: Push index 1.
//
//State: stack = [1]. result = [5, -1, -1, -1]
//
//        3. i = 2 (Value: 2)
//Stack Check: stack.peek() is index 1. Value arr[1] is 5.
//
//Comparison: Is 5 < 2? No. (2 is smaller than 5, so it can't rescue it).
//
//Action: Push index 2.
//
//State: stack = [1, 2]. result = [5, -1, -1, -1]
//
//Note: The stack is now [5, 2] in terms of values. It is decreasing.
//
//4. i = 3 (Value: 10)
//Stack Check (First): stack.peek() is index 2. Value arr[2] is 2.
//
//Comparison: Is 2 < 10? Yes!
//
//pop index 2.
//
//result[2] = 10.
//
//Stack Check (Second): stack.peek() is index 1. Value arr[1] is 5.
//
//Comparison: Is 5 < 10? Yes!
//
//pop index 1.
//
//result[1] = 10.
//
//Stack Check: Empty now.
//
//Action: Push index 3.
//
//State: stack = [3]. result = [5, 10, 10, -1]
//
//Final Result
//The loop finishes. We return result, which is [5, 10, 10, -1].