package com.anil.src;

public class CountSubsequence {
    public static void main(String[] args) {
        int[] arr = {1,2,2};
        int target = 2;
        int ans = subsequence(arr,0,target,0);
        System.out.println(ans);
    }

    private static int subsequence(int[] arr, int index, int target, int sum) {
        if (index == arr.length){
            if (sum == target){
                return 1;
            }else {
                return 0;
            }
        }

        int include = subsequence(arr,index + 1,target,sum + arr[index]);
        int exclude = subsequence(arr,index + 1,target,sum);

        return include + exclude;
    }
}

//There’s no mutable path structure being modified.
//
//        sum is a primitive, and each call gets its own copy.
//
//        There’s nothing to “undo” after recursion — each branch is independent.
//
//        The count is computed purely from return values (or a separate mutable object).
//
//        ✅ So there’s no need for backtracking.