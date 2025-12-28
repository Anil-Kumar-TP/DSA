package com.anil.src;

import java.util.*;

public class ThreeSumBetter {
    public static void main(String[] args) {
        int[] arr = {-1,0,1,2,-1,-4};
        List<List<Integer>> ans = threeSum(arr);
        System.out.println(ans);
    }

    private static List<List<Integer>> threeSum(int[] arr) {
        Set<List<Integer>> ans = new HashSet<>();

        for (int i = 0; i < arr.length; i++){
            Set<Integer> set = new HashSet<>();//when i is reset we have to clear out set.
            for (int j = i + 1; j < arr.length; j++){
                int third = -(arr[i] + arr[j]);

                if (set.contains(third)){
                    List<Integer> temp = Arrays.asList(arr[i],arr[j],third);
                    Collections.sort(temp);
                    ans.add(temp);
                }

                set.add(arr[j]);
            }
        }

        return new ArrayList<>(ans);
    }
}
