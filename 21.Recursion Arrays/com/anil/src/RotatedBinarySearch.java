package com.anil.src;

public class RotatedBinarySearch {
    public static void main(String[] args) {
        int[] arr = {5,6,7,8,9,1,2,3};
        int target = 7;
        int ans = search(arr,target,0,arr.length - 1);
        System.out.println(ans);
    }

    private static int search(int[] arr, int target,int start,int end) {

        if (start > end){
            return -1;
        }

        int mid = start + (end - start) / 2;

        if (arr[mid] == target){
            return mid;
        }

        if (arr[start] == arr[mid] && arr[mid] == arr[end]){
            int left = search(arr,target,start + 1,mid - 1);
            if (left != -1){
                return left;
            }
            return search(arr,target,mid + 1,end - 1);
        }

        if (arr[start] <= arr[mid]){
            if (arr[start] <= target && target <= arr[mid]){
                return search(arr,target,start,mid - 1);
            }else {
                return search(arr,target,mid + 1,end);
            }
        }else {
            if (arr[mid] <= target && target <= arr[end]){
                return search(arr,target,mid + 1,end);
            }else {
                return search(arr,target,start,mid - 1);
            }
        }
    }
}
