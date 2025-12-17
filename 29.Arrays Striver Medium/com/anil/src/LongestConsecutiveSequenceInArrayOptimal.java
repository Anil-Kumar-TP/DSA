package com.anil.src;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequenceInArrayOptimal {
    public static void main(String[] args) {
        int[] arr = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        int ans = longest(arr);
        System.out.println(ans);
    }

    private static int longest(int[] arr) {
        int longest = 1;

        if (arr.length == 0){
            return 0;
        }

        Set<Integer> set = new HashSet<>();

        for (int num : arr) {
            set.add(num);
        }

        for (int num : set){
            if (!set.contains(num - 1)){
                int count = 1;
                int currentNumber = num;

                while (set.contains(currentNumber + 1)){
                    currentNumber = currentNumber + 1;
                    count = count + 1;
                }

                longest = Math.max(longest,count);
            }
        }
        return longest;
    }
}

//I only start counting when the previous number does not exist
// If there is no number before 'it', it’s the start of a sequence
