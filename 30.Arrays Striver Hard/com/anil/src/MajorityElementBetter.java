package com.anil.src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorityElementBetter {
    public static void main(String[] args) {
        int[] arr = {1,1,1,1,3,2,2,2,2};
        List<Integer> ans = majority(arr);
        System.out.println(ans);
    }

    private static List<Integer> majority(int[] arr) {
        List<Integer> ans = new ArrayList<>();

        Map<Integer,Integer> map = new HashMap<>();

        for (int num : arr){
            map.put(num,map.getOrDefault(num,0) + 1);
        }

        for (Map.Entry<Integer,Integer> entry : map.entrySet()){
            if (entry.getValue() > arr.length / 3){
                ans.add(entry.getKey());
            }
        }

        return ans;
    }
}
