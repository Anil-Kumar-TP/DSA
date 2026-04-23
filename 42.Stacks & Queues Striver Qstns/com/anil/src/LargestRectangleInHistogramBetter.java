package com.anil.src;

import java.util.Stack;

public class LargestRectangleInHistogramBetter {
    public static void main(String[] args) {
        int[] heights = {2,1,5,6,2,3};
        int ans = largestRectangleArea(heights);
        System.out.println(ans);
    }

    //pre compute both nse and pse.
    private static int largestRectangleArea(int[] heights) {
        int n = heights.length;

        int[] pse = new int[n];
        int[] nse = new int[n];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++){
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                stack.pop();
            }

            pse[i] = !stack.isEmpty() ? stack.peek() : -1;
            stack.push(i);
        }

        for (int i = n - 1; i >= 0; i--){
            while (!stack.isEmpty() &&  heights[stack.peek()] >= heights[i]){
                stack.pop();
            }

            nse[i] = !stack.isEmpty() ? stack.peek() : n;
            stack.push(i);
        }

        int maxArea = 0;

        for (int i = 0; i < n; i++){
            int width = nse[i] - pse[i] - 1;
            int area = heights[i] * width;

            maxArea = Math.max(maxArea,area);
        }

        return maxArea;
    }
}
