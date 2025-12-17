package com.anil.src;

public class LongestConsecutiveSequenceInArrayBruteForce {
    public static void main(String[] args) {
        int[] arr = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        int ans = longest(arr);
        System.out.println(ans);
    }

    private static int longest(int[] arr) {
        if (arr.length == 0){
            return 0;
        }

        int longest = 1;
        for (int i = 0; i < arr.length; i++){
            int currentNumber = arr[i];
            int count = 1;
            while (linearSearch(arr, currentNumber + 1)){
                currentNumber = currentNumber + 1;
                count = count + 1;
            }

            longest = Math.max(longest,count);
        }

        return longest;
    }

    private static boolean linearSearch(int[] arr, int num) {
        for (int i = 0; i < arr.length; i++){
            if (arr[i] == num){
                return true;
            }
        }
        return false;
    }
}


//count is fully computed first
//
//The while loop runs to completion
//
//When it ends, count has its final value for this i
//
//Then, exactly once per outer iteration:
//
//largest = Math.max(largest, count);

//A for loop is for known or bounded iteration counts.
//        A while loop is for condition-driven progression.
//
//        “Keep extending the sequence as long as the next number exists.”


//The precise version (this matters)
//
//Select a number x
//While x + 1 exists:
//advance x
//increase count
//When it stops, count is the length of the consecutive sequence starting at the original number
//Compare count with largest and update if needed
//
//That’s the exact algorithmic invariant.
//
//        Timeline view (execution order)
//
//Let’s take your example: starting at 3
//
//Initial:
//
//currentNumber = 3
//count = 1
//largest = (previous best)
//
//Loop execution:
//check 4 → exists → move to 4, count = 2
//check 5 → exists → move to 5, count = 3
//check 6 → exists → move to 6, count = 4
//check 7 → exists → move to 7, count = 5
//check 8 → exists → move to 8, count = 6
//check 9 → not exist → stop
//
//
//Now:
//
//count = 6
//
//
//Then:
//
//largest = max(largest, count)
//
//
//Exactly once.