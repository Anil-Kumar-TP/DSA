package com.anil.src;

public class CountPermutationInBody {
    public static void main(String[] args) {
        int ans = countPermutation("","abc");
        System.out.println(ans);
    }

    private static int countPermutation(String finalOne, String initialOne) {
        if (initialOne.isEmpty()){
            return 1;
        }
        int count = 0;
        char ch = initialOne.charAt(0);
        for (int i = 0; i <= finalOne.length(); i++){
            String first = finalOne.substring(0,i);
            String second = finalOne.substring(i,finalOne.length());
            count = count + countPermutation(first + ch + second,initialOne.substring(1));
        }
        return count;
    }
}
