package com.anil.src;

public class PalindromeSingleParameter {
    public static void main(String[] args) {
        String str = "Malayalam";
        boolean ans = isPalindrome(str,0);
        System.out.println(ans);
    }

    private static boolean isPalindrome(String str, int index) {
        str = str.toLowerCase();
        if (index >= str.length() / 2){
            return true;
        }
        if (str.charAt(index) != str.charAt(str.length() - index - 1)){
            return false;
        }
        return isPalindrome(str,index + 1);
    }
}
