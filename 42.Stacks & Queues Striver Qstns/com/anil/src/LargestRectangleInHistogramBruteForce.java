package com.anil.src;

public class LargestRectangleInHistogramBruteForce {
    public static void main(String[] args) {
        int[] heights = {2,1,5,6,2,3};
        int ans = largestRectangleArea(heights);
        System.out.println(ans);
    }

    private static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int maxArea = 0;

        for (int i = 0; i < n; i++){
            int minHeight = Integer.MAX_VALUE;

            for (int j = i; j < n; j++){
                minHeight = Math.min(minHeight,heights[j]);

                int area = minHeight * (j - i + 1);
                maxArea = Math.max(area,maxArea);
            }
        }
        return maxArea;
    }
}
