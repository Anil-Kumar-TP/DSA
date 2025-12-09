package com.anil.src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SubsetSum1 {
    public static void main(String[] args) {
        int[] arr = {5,2,1};
        List<Integer> ans = new ArrayList<>();
        subsetSum(arr,0,0,ans);
        Collections.sort(ans);
        System.out.println(ans);
    }

    private static void subsetSum(int[] arr, int index, int sum, List<Integer> ans) {
        if (index == arr.length){
            ans.add(sum);
            return;
        }
        subsetSum(arr,index + 1,sum + arr[index],ans);
        subsetSum(arr,index + 1,sum,ans);
    }
}

//no need of backtracking,bcs sum is just primitive and not a shared mutable path.
