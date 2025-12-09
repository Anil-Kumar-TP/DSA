package com.anil.src;

public class SecondLargestElementBetter {
    public static void main(String[] args) {
        int[] arr = {1,4,2,9,9,5};
        int ans = secondLargest(arr);
        System.out.println(ans);
    }

    private static int secondLargest(int[] arr) {
        int largest = largest(arr);
        int secondLargest = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++){
            if (arr[i] > secondLargest && arr[i] != largest){
                secondLargest = arr[i];
            }
        }
        return secondLargest;
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
