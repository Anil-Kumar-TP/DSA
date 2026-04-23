package com.anil.src;

import java.util.Arrays;

public class NextGreaterElement1BruteForce {
    public static void main(String[] args) {
        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};
        int[] ans = nextGreaterElement(nums1,nums2);
        System.out.println(Arrays.toString(ans));
    }

    private static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++){
            int index = -1;
            int target = nums1[i];

            //find index in nums2.
            for (int j = 0; j < nums2.length; j++){
                if (nums2[j] == target){
                    index = j;
                    break;
                }
            }

            int nextGreater = -1;
            for (int j = index + 1; j < nums2.length; j++){
                if (nums2[j] > target){
                    nextGreater = nums2[j];
                    break;
                }
            }

            result[i] = nextGreater;
        }

        return result;
    }
}
