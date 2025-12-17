package com.anil.src;

import java.util.HashMap;
import java.util.Map;

public class MajorityElementBetter {
    public static void main(String[] args) {
        int[] arr = {7, 0, 0, 1, 7, 7, 2, 7, 7};
        int ans = majority(arr);
        System.out.println(ans);
    }

    private static int majority(int[] arr) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : arr){
            map.put(num,map.getOrDefault(num,0) + 1);
        }

        for (Map.Entry<Integer,Integer> entry : map.entrySet()){
            if (entry.getValue() > arr.length / 2){
                return entry.getKey();
            }
        }
        return -1;
    }
}
