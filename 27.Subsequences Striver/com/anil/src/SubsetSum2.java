package com.anil.src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetSum2 {
    public static void main(String[] args) {
        int[] arr = {1,2,2};
        Arrays.sort(arr);
        List<List<Integer>> list = new ArrayList<>();
        subsets(arr,0,new ArrayList<>(),list);
        System.out.println(list);
    }

    private static void subsets(int[] arr, int index, ArrayList<Integer> path, List<List<Integer>> list) {

        //notice that there is no explicit base case bcs for loop act like that
        //also we have to add an empty list in the beginning
        //but combination sum 2 even though had a for loop,it still has a base case
        //bcs that is controlled means the list are added only when sum == target.
        //here that is not the case.
        list.add(new ArrayList<>(path));

        for (int i = index; i < arr.length; i++){
            if (i > index && arr[i] == arr[i - 1]){
                continue;
            }
            path.add(arr[i]);
            subsets(arr,i + 1,path,list);
            path.remove(path.size() - 1);
        }
    }
}
