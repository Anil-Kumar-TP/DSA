package com.anil.src;

public class SortedOrNot {
    public static void main(String[] args) {
        int[] arr = {3,9,1,0,1};
        boolean ans = isSorted(arr);
        System.out.println(ans);
    }

    private static boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++){
            if (arr[i] < arr[i - 1]) {
                return false;
            }
        }
        return true;
    }
}
