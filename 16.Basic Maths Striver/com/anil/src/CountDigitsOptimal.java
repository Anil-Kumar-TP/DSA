package com.anil.src;

public class CountDigitsOptimal {
    public static void main(String[] args) {
        int n = 123;
        int ans = count(n);
        System.out.println(ans);
    }

    private static int count(int n) {
        return (int) (Math.log10(n) + 1);
    }
}

