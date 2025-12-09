package com.anil.src;

public class PalindromeParameterised {
    public static void main(String[] args) {
        String str = "Malayalam";
        boolean ans = isPalindrome(str,0,str.length() - 1);
        System.out.println(ans);
    }

    private static boolean isPalindrome(String str,int start,int end) {
        str = str.toLowerCase();
        if (start >= end){
            return true;
        }
        if (str.charAt(start) != str.charAt(end)){
            return false;
        }
        return isPalindrome(str,start + 1,end - 1);
    }
}
