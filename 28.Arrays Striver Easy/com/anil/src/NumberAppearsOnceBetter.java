package com.anil.src;

import java.util.HashMap;
import java.util.Map;

public class NumberAppearsOnceBetter {
    public static void main(String[] args) {
        int[] arr = {1,1,2,3,3,4,4};
        int ans = numbers(arr);
        System.out.println(ans);
    }

    //numbers can be large.so hash array is not good.use hashmap.
    //if we used hash array the size of it would be the max element + 1.
    //if element is larger this wastes space.
    private static int numbers(int[] arr) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : arr){
            map.put(num,map.getOrDefault(num,0) + 1);
        }

        for (int num : arr){
            if (map.get(num) == 1){
                return num;
            }
        }

        return -1;
    }
}



