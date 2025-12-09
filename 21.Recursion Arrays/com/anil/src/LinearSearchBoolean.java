package com.anil.src;

public class LinearSearchBoolean {
    public static void main(String[] args) {
        int[] arr = {3,4,1,5,7,9};
        int target = 1;
        boolean ans = linearSearch(arr,target,0);
        System.out.println(ans);
    }

    private static boolean linearSearch(int[] arr, int target, int index) {
        if (index == arr.length){
            return false;
        }
        if (arr[index] == target){
            return true;
        }
        return linearSearch(arr,target,index + 1);
    }
}
