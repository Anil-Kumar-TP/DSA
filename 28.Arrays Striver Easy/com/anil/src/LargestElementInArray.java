package com.anil.src;

public class LargestElementInArray {
    public static void main(String[] args) {
        int[] arr = {13,3,21,9,72,33};
        int ans = largest(arr);
        System.out.println(ans);
    }

    private static int largest(int[] arr) {
        int largest = arr[0];
        for (int i = 0; i < arr.length; i++){
            if (arr[i] > largest){
                largest = arr[i];
            }
        }
        return largest;
    }
}
