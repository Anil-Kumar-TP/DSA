package com.anil.src;

import java.util.ArrayList;
import java.util.List;

public class MajorityElementOptimal {
    public static void main(String[] args) {
        int[] arr = {1,1,1,1,3,2,2,2,2};
        List<Integer> ans = majority(arr);
        System.out.println(ans);
    }

    private static List<Integer> majority(int[] arr) {
        int element1 = Integer.MIN_VALUE;
        int element2 = Integer.MIN_VALUE;
        int count1 = 0;
        int count2 = 0;

        for (int i = 0; i < arr.length; i++){
            if (count1 == 0 && element2 != arr[i]){
                count1 = 1;
                element1 = arr[i];
            }else if (count2 == 0 && element1 != arr[i]){
                count2 = 1;
                element2 = arr[i];
            }else if (element1 == arr[i]){
                count1++;
            }else if (element2 == arr[i]){
                count2++;
            }else {
                count1--;
                count2--;
            }
        }

        List<Integer> ans = new ArrayList<>();
        int counter1 = 0;
        int counter2 = 0;

        for (int i = 0; i < arr.length; i++){
            if (element1 == arr[i]){
                counter1++;
            }
            if (element2 == arr[i]){
                counter2++;
            }
        }

        int minimum = arr.length / 3 + 1;

        if (counter1 >= minimum){
            ans.add(element1);
        }
        if (counter2 >= minimum && element1 != element2){
            ans.add(element2);
        }

        return ans;
    }
}

//Every time you see three different elements, they can all be discarded — none of them can be a majority.
//n/2 → 1 candidate
//
//n/3 → 2 candidates
//
//n/k → k−1 candidates