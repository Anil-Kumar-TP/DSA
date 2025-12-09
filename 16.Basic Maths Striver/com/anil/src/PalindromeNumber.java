package com.anil.src;

public class PalindromeNumber {
    public static void main(String[] args) {
        int n = 131;
        boolean ans = isPalindrome(n);
        System.out.println(ans);
    }

    private static boolean isPalindrome(int n) {
        int originalNumber = n;
        int reversedNumber = 0;
        while (n > 0) {
            int rem = n % 10;
            n = n / 10;
            reversedNumber = reversedNumber * 10 + rem;
        }
        return (originalNumber == reversedNumber);
    }
}
