package com.anil.src;

import java.util.*;

public class ThreeSumBruteForce {
    public static void main(String[] args) {
        int[] arr = {-1,0,1,2,-1,-4};
        List<List<Integer>> ans = threeSum(arr);
        System.out.println(ans);
    }

    private static List<List<Integer>> threeSum(int[] arr) {

        Set<List<Integer>> set = new HashSet<>();

        for (int i = 0; i < arr.length; i++){
            for (int j = i + 1; j < arr.length; j++){
                for (int k = j + 1; k < arr.length; k++){
                    if (arr[i] + arr[j] + arr[k] == 0){
                        List<Integer> temp = Arrays.asList(arr[i],arr[j],arr[k]);
                        Collections.sort(temp);
                        set.add(temp);
                    }
                }
            }
        }

        return new ArrayList<>(set);
    }
}
