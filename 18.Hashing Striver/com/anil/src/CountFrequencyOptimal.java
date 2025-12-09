package com.anil.src;

import java.util.HashMap;
import java.util.Map;

public class CountFrequencyOptimal {
    public static void main(String[] args) {
        int[] arr = {1,1,2,3,2,4,5};
        Map<Integer,Integer> ans = count(arr);
        System.out.println(ans);
    }

    private static Map<Integer, Integer> count(int[] arr) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : arr){
            map.put(num,map.getOrDefault(num,0) + 1);
        }
        return map;
    }
}
