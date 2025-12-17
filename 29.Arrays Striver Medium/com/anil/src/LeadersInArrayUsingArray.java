package com.anil.src;

import java.util.Arrays;

public class LeadersInArrayUsingArray {
    public static void main(String[] args) {
        int[] arr = {10,22,12,3,0,6};
        int[] ans = leaders(arr);
        System.out.println(Arrays.toString(ans));
    }

    private static int[] leaders(int[] arr) {
        int countOfLeaders = 0;
        int[] temp = new int[arr.length];//size n cus we dont know how many leaders will be there.
        for (int i = 0; i < arr.length; i++){
            boolean leader = true;
            for (int j = i + 1; j < arr.length; j++){
                if (arr[j] > arr[i]){
                    leader = false;
                    break;
                }
            }

            //temp will contain the leaders,but remaining will be zeroes
            //so need a result array.
            if (leader){
                temp[countOfLeaders] = arr[i];
                countOfLeaders++;
            }
        }

        int[] result = new int[countOfLeaders];
        for (int i = 0; i < countOfLeaders; i++){
            result[i] = temp[i];
        }

        return result;
    }
}
