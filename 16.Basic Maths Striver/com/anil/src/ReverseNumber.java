package com.anil.src;

public class ReverseNumber {
    public static void main(String[] args) {
        int n = 578900;
        int ans = reverse(n);
        System.out.println(ans);
    }

    private static int reverse(int n) {
        int reversedNumber = 0;
        while (n > 0){
            int rem = n % 10;
            n = n / 10;
            reversedNumber = reversedNumber * 10 + rem;
        }
        return reversedNumber;
    }
}
