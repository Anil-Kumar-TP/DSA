package com.anil.src;

import java.util.ArrayList;
import java.util.List;

public class SubsequenceWhoseSumIsKOnlyOne {
    public static void main(String[] args) {
        int[] arr = {1,2,1};
        int target = 2;
        List<Integer> path = new ArrayList<>();
        subsequence(arr,0,path,target,0);
        System.out.println(path);
    }

    private static boolean subsequence(int[] arr, int index, List<Integer> path, int target, int sum) {
        if (index == arr.length){
            if (sum == target){
                return true;
            }
            return false;
        }

        path.add(arr[index]);
        if (subsequence(arr,index + 1,path,target,sum + arr[index])){
            return true;
        }
        path.remove(path.size() - 1);
        if (subsequence(arr,index + 1,path,target,sum)){
            return true;
        }
        return false;
    }
}
