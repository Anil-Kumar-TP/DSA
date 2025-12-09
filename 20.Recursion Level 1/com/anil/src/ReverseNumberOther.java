package com.anil.src;

public class ReverseNumberOther {
    public static void main(String[] args) {
        int n = 3741;
        int ans = reverse(n);
        System.out.println(ans);
    }

    private static int reverse(int n) {
        if (n < 10){
            return n;
        }

        int digits = (int) Math.log10(n);
        int rem = n % 10;

        return rem * (int) Math.pow(10, digits) + reverse(n / 10);
    }
}
