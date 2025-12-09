package com.anil.src;

public class CountPermutationInParams {
    public static void main(String[] args) {
        int ans = countPermutation("","abc",0);
        System.out.println(ans);
    }

    private static int countPermutation(String finalOne, String initialOne, int count) {
        if (initialOne.isEmpty()){
            return count + 1;
        }
        char ch = initialOne.charAt(0);
        for (int i = 0; i <= finalOne.length(); i++){
            String first = finalOne.substring(0,i);
            String second = finalOne.substring(i,finalOne.length());
            count = countPermutation(first + ch + second,initialOne.substring(1),count);
        }
        return count;
    }
}
