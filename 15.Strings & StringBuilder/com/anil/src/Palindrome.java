package com.anil.src;

public class Palindrome {
    public static void main(String[] args) {
        String name = "Malayalam";
        boolean ans = isPalindrome(name);
        System.out.println(ans);
    }

    private static boolean isPalindrome(String name) {
        name = name.toLowerCase();
        int start = 0;
        int end = name.length() - 1;
        while (start < end){
            if (name.charAt(start) != name.charAt(end)){
                return false;
            }else {
                start++;
                end--;
            }
        }
        return true;
    }
}
