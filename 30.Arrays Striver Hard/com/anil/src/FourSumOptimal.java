package com.anil.src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSumOptimal {
    public static void main(String[] args) {
        int[] arr = {1,0,-1,0,-2,2};
        int target = 0;
        Arrays.sort(arr);
        List<List<Integer>> ans = fourSum(arr, target);
        System.out.println(ans);
    }

    private static List<List<Integer>> fourSum(int[] arr, int target) {
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < arr.length; i++){
            if (i > 0 && arr[i] == arr[i - 1]){
                continue;
            }

            for (int j = i + 1; j < arr.length; j++){
                if (j > i + 1 && arr[j] == arr[j - 1]){
                    continue;
                }

                int left = j + 1;
                int right = arr.length - 1;

                while (left < right){
                    long sum = (long) arr[i] + arr[j] + arr[left] + arr[right];

                    if (sum == target){
                        List<Integer> temp = Arrays.asList(arr[i],arr[j],arr[left],arr[right]);
                        ans.add(temp);
                        left++;
                        right--;
                        while (left < right && arr[left] == arr[left - 1]){
                            left++;
                        }
                        while (left < right && arr[right] == arr[right + 1]){
                            right--;
                        }
                    }else if (sum < target){
                        left++;
                    }else {
                        right--;
                    }
                }
            }
        }
        return ans;
    }
}
