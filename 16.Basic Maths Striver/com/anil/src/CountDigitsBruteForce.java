package com.anil.src;

public class CountDigitsBruteForce {
    public static void main(String[] args) {
        int n = 123;
        int ans = count(n);
        System.out.println(ans);
    }

    private static int count(int n) {
        int count = 0;
        while (n > 0){
            count = count + 1;
            n = n / 10;
        }
        return count;
    }
}
