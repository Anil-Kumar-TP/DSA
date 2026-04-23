package com.anil.src;

import static com.anil.src.LargestRectangleInHistogramOptimal.largestRectangleArea;

public class MaximalRectangle {
    public static void main(String[] args) {
        char[][] matrix = {
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };
        int ans = maximalRectangle(matrix);
        System.out.println(ans);
    }

    private static int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }

        int cols = matrix[0].length;
        int[] heights = new int[cols];
        int maxArea = 0;

        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < cols; j++){
                if (matrix[i][j] == '1'){
                    heights[j] += 1;
                }else {
                    heights[j] = 0; //not +=
                }
            }

            maxArea = Math.max(maxArea,largestRectangleArea(heights));
        }

        return maxArea;
    }
}


//        [1, 1]  <- Row 0
//        [1, 1]  <- Row 1
//
//        1. The Starting Line
//int[] heights = new int[2];
//Initially, your table is empty: [0, 0]
//
//        2. Processing Row 0 (The Scanner moves Left to Right)
//The outer loop picks Row 0. The inner loop visits each column:
//
//Col 0: The cell is '1'. Logic: heights[0] += 1. Array is now [1, 0].
//
//Col 1: The cell is '1'. Logic: heights[1] += 1. Array is now [1, 1].
//
//The Histogram: You now have a "floor" with two blocks standing next to each other. Your code calls largestRectangleArea([1, 1]), which finds a rectangle of Area 2.
//
//        3. Processing Row 1 (The Scanner moves Left to Right again)
//Now the outer loop moves down to Row 1. Crucially, the heights array still holds [1, 1] from the step before.
//
//Col 0: The cell is '1'. Logic: heights[0] += 1. (1 + 1 = 2). Array is now [2, 1].
//
//Col 1: The cell is '1'. Logic: heights[1] += 1. (1 + 1 = 2). Array is now [2, 2].
//
//The Histogram: You now have a new "floor." On this floor, you have two towers, each 2 blocks high. Your code calls largestRectangleArea([2, 2]), which finds a rectangle of Area 4.
//
//Why this works for your brain
//The reason it feels like it's "built up vertically" is because of that += 1 part.
//
//The Secret: The heights array is outside the inner loop. It doesn't get wiped clean when you move to a new row. It stays in memory, "remembering" how tall the towers were on the floor above.