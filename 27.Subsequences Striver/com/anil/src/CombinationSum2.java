package com.anil.src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//Duplicate numbers are allowed; duplicate combinations are NOT
//At a given recursion level, if you choose the first 1, you must skip choosing the second 1 as the first choice of that level, or else you would generate the same combination twice.
public class CombinationSum2 {
    public static void main(String[] args) {
        int[] arr = {10,1,2,7,6,1,5};
        Arrays.sort(arr);
        int target = 8;
        List<List<Integer>> list = new ArrayList<>();
        combination(arr,0,target,new ArrayList<>(),list);
        System.out.println(list);
    }

    private static void combination(int[] arr, int index, int target, ArrayList<Integer> path, List<List<Integer>> list) {
        if (target == 0){
            list.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < arr.length; i++){
            if (i > index && arr[i] == arr[i - 1]){
                continue;
            }
            if (arr[i] > target){
                break;
            }

            path.add(arr[i]);
            combination(arr,i + 1,target - arr[i],path,list);
            path.remove(path.size() - 1);
        }
    }
}

//i > index is given bcs duplicates must be skipped only at the same recursion depth, NOT across different depths.


//    If input may contain duplicates AND
//if the problem wants unique subsets/combinations,
//        ➡ You MUST sort the input.
//
//
//
//        also cant we write something like this if nums[i] <= target do those steps instead of writing like break
//
//        Suppose target = 4.
//
//        When you hit 5:
//
//        If you write:
//
//        if (nums[i] <= target) recurse...
//
//
//        → The loop will still continue to check 7, 9, 10, etc.
//        → Wasting iterations
//
//        But if you write:
//
//        if (nums[i] > target) break;
//
//
//        → Since the array is sorted, EVERYTHING after 5 (including 7,…)
//        is also guaranteed > target
//        → So you stop immediately.