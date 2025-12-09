package com.anil.src;

public class PalindromeNumber {
    public static void main(String[] args) {
        int n = 171;
        boolean ans = isPalindrome(n);
        System.out.println(ans);
    }

    private static boolean isPalindrome(int n) {
        return n == reverse(n,0);
    }

    private static int reverse(int n, int reverseNumber) {
        if (n == 0){
            return reverseNumber;
        }
        int rem = n % 10;
        reverseNumber = reverseNumber * 10 + rem;

        return reverse(n / 10,reverseNumber);
    }
}
