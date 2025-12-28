package com.anil.src;

import java.util.ArrayList;
import java.util.List;

//at most there can only be 2 elements in the list.
public class MajorityElementBruteForce {
    public static void main(String[] args) {
        int[] arr = {1,1,1,1,3,2,2,2,2};
        List<Integer> ans = majority(arr);
        System.out.println(ans);
    }

    private static List<Integer> majority(int[] arr) {
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < arr.length; i++){
            //or instead of this if, just use if(!ans.contain(arr[i])
            if (ans.isEmpty() || ans.get(0) != arr[i] && (ans.size() < 2 || ans.get(1) != arr[i])){
                int count = 0;
                for (int j = 0; j < arr.length; j++){
                    if (arr[j] == arr[i]){
                        count++;
                    }
                }

                if (count > arr.length / 3){
                    ans.add(arr[i]);
                }
            }

            if (ans.size() == 2){
                break;
            }
        }

        return ans;
    }
}
