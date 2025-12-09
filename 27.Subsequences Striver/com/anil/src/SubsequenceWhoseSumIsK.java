package com.anil.src;

import java.util.ArrayList;
import java.util.List;

public class SubsequenceWhoseSumIsK {
    public static void main(String[] args) {
        int[] arr = {1,2,1};
        int target = 2;
        List<List<Integer>> list = new ArrayList<>();
        subsequence(arr,0,target,0,new ArrayList<>(),list);
        System.out.println(list);
    }

    private static void subsequence(int[] arr, int index,int target,int sum, ArrayList<Integer> path, List<List<Integer>> list) {
        if (index == arr.length){
           if (sum == target){
               list.add(new ArrayList<>(path));
           }
           return;
        }

        path.add(arr[index]);
        subsequence(arr,index + 1,target,sum + arr[index],path,list);
        path.remove(path.size() - 1);
        subsequence(arr,index + 1,target,sum,path,list);
    }
}
