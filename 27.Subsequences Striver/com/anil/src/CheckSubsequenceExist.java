package com.anil.src;

public class CheckSubsequenceExist {
    public static void main(String[] args) {
        int[] arr = {1,2,1};
        int target = 2;
        boolean ans = subsequence(arr,0,target,0);
        System.out.println(ans);
    }

    private static boolean subsequence(int[] arr, int index, int target, int sum) {
        if (index == arr.length){
            if (sum == target){
                return true;
            }else {
                return false;
            }
        }

        if (subsequence(arr,index + 1,target,sum + arr[index])){
            return true;
        }

        if (subsequence(arr,index + 1,target,sum)){
            return true;
        }

        return false;
    }
}


//Here:
//
//        No path list
//
//        No shared list
//
//        Only ints
//
//        Nothing to “undo”
//
//        No backtracking needed.