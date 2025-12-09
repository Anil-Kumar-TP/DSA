package com.anil.src;

import java.util.ArrayList;
import java.util.List;

public class IntersectionOfTwoSortedArraysBruteForce {
    public static void main(String[] args) {
        int[] arr1 = {1,2,2,3,3,4,5,6};
        int[] arr2 = {2,3,3,5,6,6,7};
        List<Integer> ans = intersection(arr1,arr2);
        System.out.println(ans);
    }

    private static List<Integer> intersection(int[] arr1, int[] arr2) {

        List<Integer> ans = new ArrayList<>();

        int[] visited = new int[arr2.length];

        for (int i = 0; i < arr1.length; i++){
            for (int j = 0; j < arr2.length; j++){
                if (arr1[i] == arr2[j] && visited[j] == 0){
                    ans.add(arr1[i]);
                    visited[j] = 1;
                    break;
                }

                if (arr2[j] > arr1[i]){
                    break;//bcs sorted
                }
            }
        }
        return ans;
    }
}
