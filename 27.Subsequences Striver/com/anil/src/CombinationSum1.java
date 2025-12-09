package com.anil.src;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum1 {
    public static void main(String[] args) {
        int[] arr = {2,3,6,7};
        int target = 7;
        List<List<Integer>> list = new ArrayList<>();
        combination(arr,0,target,new ArrayList<>(),list);
        System.out.println(list);
    }

    private static void combination(int[] arr, int index, int target, ArrayList<Integer> path, List<List<Integer>> list) {
        if (target == 0){
            list.add(new ArrayList<>(path));
            return;
        }

        if (index == arr.length){
            return;
        }

        // PICK — stay at same index because unlimited usage
        if (arr[index] <= target){
            path.add(arr[index]);
            combination(arr,index,target - arr[index],path,list); //not index + 1 as we can stay on that
            path.remove(path.size() - 1);//element multiple times.
        }

        combination(arr,index + 1,target,path,list);//not pick & move forward
    }
}
