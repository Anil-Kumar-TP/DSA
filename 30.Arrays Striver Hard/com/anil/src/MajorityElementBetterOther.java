package com.anil.src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorityElementBetterOther {
    public static void main(String[] args) {
        int[] arr = {1,1,1,1,3,2,2,2,2};
        List<Integer> ans = majority(arr);
        System.out.println(ans);
    }

    private static List<Integer> majority(int[] arr) {
        List<Integer> ans = new ArrayList<>();

        Map<Integer,Integer> map = new HashMap<>();

        int minimum = arr.length / 3 + 1;

        for (int i = 0; i < arr.length; i++){
            map.put(arr[i],map.getOrDefault(arr[i],0) + 1);

            if (map.get(arr[i]) == minimum){
                ans.add(arr[i]);
            }

            if (ans.size() == 2){
                break;
            }
        }
        return ans;
    }

}
