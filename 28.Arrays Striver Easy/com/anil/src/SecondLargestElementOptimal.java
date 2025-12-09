package com.anil.src;

public class SecondLargestElementOptimal {
    public static void main(String[] args) {
        int[] arr = {1,4,2,9,9,5};
        int ans = secondLargest(arr);
        System.out.println(ans);
    }

    private static int secondLargest(int[] arr) {
        int largest = arr[0];
        int secondLargest = Integer.MIN_VALUE;
        for (int i = 1; i < arr.length; i++){
            if (arr[i] > largest){
                secondLargest = largest;
                largest = arr[i];
            }else if (arr[i] < largest && arr[i] > secondLargest){
                secondLargest = arr[i];
            }
        }
        return secondLargest;
    }
}
