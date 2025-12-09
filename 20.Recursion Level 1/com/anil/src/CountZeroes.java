package com.anil.src;

public class CountZeroes {
    public static void main(String[] args) {
        int n = 302001;
        int ans = countZeroes(n,0);
        System.out.println(ans);
    }

    private static int countZeroes(int n,int count) {
        if (n == 0) return count;

        int rem = n % 10;
        if (rem == 0) count++;

        return countZeroes(n / 10, count);
    }
}
