package com.anil.src;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {3,4,5,7,9};
        int target = 7;
        int ans = search(arr,target,0,arr.length - 1);
        System.out.println(ans);
    }

    private static int search(int[] arr, int target, int start, int end) {

        if (start > end){
            return -1;
        }

        int mid = start + (end - start) / 2;

        if (arr[mid] == target){
            return mid;
        }

        if (arr[mid] < target){
            return search(arr,target,mid + 1,end);
        }else {
            return search(arr,target,start,mid - 1);
        }
    }
}
