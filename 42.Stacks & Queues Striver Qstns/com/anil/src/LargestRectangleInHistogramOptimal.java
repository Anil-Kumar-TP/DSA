package com.anil.src;

import java.util.Stack;

public class LargestRectangleInHistogramOptimal {
    public static void main(String[] args) {
        int[] heights = {2,1,5,6,2,3};
        int ans = largestRectangleArea(heights);
        System.out.println(ans);
    }

    static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;

        for (int i = 0; i < n; i++){
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]){
                int height = heights[stack.pop()];
                int right = i;
                int left = stack.isEmpty() ? -1 : stack.peek();
                int width = right - left - 1;
                int area = height * width;
                maxArea = Math.max(maxArea,area);
            }
            stack.push(i);
        }

        while (!stack.isEmpty()){
            int height = heights[stack.pop()];
            int right = n; //nothing smaller
            int left = stack.isEmpty() ? -1 : stack.peek();
            int width = right - left - 1;
            int area = height * width;
            maxArea = Math.max(maxArea,area);
        }

        return maxArea;
    }
}
