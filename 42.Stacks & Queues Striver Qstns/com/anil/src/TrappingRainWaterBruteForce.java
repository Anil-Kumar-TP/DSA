package com.anil.src;

public class TrappingRainWaterBruteForce {
    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        int ans = trap(height);
        System.out.println(ans);
    }

    private static int trap(int[] height) {
        int totalWater = 0;

        for (int i = 0; i < height.length; i++){
            int leftMax = 0;
            int rightMax = 0;

            for (int j = i; j >= 0; j--){
                leftMax = Math.max(leftMax,height[j]);
            }

            for (int j = i; j < height.length; j++){
                rightMax = Math.max(rightMax,height[j]);
            }

            totalWater = totalWater + Math.min(leftMax,rightMax) - height[i];
        }

        return totalWater;
    }
}
