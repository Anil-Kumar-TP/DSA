package com.anil.src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumOptimal {
    public static void main(String[] args) {
        int[] arr = {-1,0,1,2,-1,-4};
        Arrays.sort(arr);
        List<List<Integer>> ans = threeSum(arr);
        System.out.println(ans);
    }

    private static List<List<Integer>> threeSum(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < arr.length; i++){
            if (i > 0 && arr[i] == arr[i - 1]){
                continue;
            }
            int left = i + 1;
            int right = arr.length - 1;

            while (left < right){
                int sum = arr[i] + arr[left] + arr[right];

                if (sum == 0){
                    List<Integer> temp = Arrays.asList(arr[i],arr[left],arr[right]);
                    ans.add(temp);
                    left++;
                    right--;
                    while (left < right && arr[left] == arr[left - 1]){
                        left++;
                    }
                    while (left < right && arr[right] == arr[right + 1]){
                        right--;
                    }
                }else if (sum < 0){
                    left++;
                }else {
                    right--;
                }
            }
        }
        return ans;
    }
}


//You’re asking:
//
//        “If we already have while loops to skip duplicates, why do we still do left++ and right-- immediately after finding a triplet?”
//
//Short answer:
//
//Because skipping duplicates only makes sense after you move to the next candidate pair.