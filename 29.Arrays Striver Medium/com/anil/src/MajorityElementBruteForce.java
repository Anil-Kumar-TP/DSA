package com.anil.src;

public class MajorityElementBruteForce {
    public static void main(String[] args) {
        int[] arr = {7, 0, 0, 1, 7, 7, 2, 7, 7};
        int ans = majority(arr);
        System.out.println(ans);
    }

    private static int majority(int[] arr) {
        for (int i = 0; i < arr.length; i++){
            int count = 0;
            for (int j = 0; j < arr.length; j++){
                if (arr[i] == arr[j]){
                    count++;
                }
            }
            if (count > arr.length / 2){
                return arr[i];
            }
        }
        return -1;
    }
}
