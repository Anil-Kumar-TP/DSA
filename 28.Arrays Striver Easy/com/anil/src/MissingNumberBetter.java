package com.anil.src;

public class MissingNumberBetter {
    public static void main(String[] args) {
        int[] arr = {1,2,4,5};
        int n = 5;
        int ans = missing(arr,n);
        System.out.println(ans);
    }

    //the range is guaranteed to be from 1 till n
    //thats why we use hash array here
    //if the range were not certain and was large we would have used hashmap
    private static int missing(int[] arr, int n) {
        int[] hash = new int[n + 1];

        for (int num : arr){
            hash[num] = 1;
        }

        for (int i = 1; i < hash.length; i++){
            if (hash[i] == 0){
                return i;
            }
        }

        return -1;
    }
}
