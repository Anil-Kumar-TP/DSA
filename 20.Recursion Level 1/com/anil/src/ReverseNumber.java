package com.anil.src;

public class ReverseNumber {
    public static void main(String[] args) {
        int ans = reverse(3741,0);
        System.out.println(ans);
    }

    private static int reverse(int n,int reverseNumber) {
        if (n == 0){
            return reverseNumber;
        }
        int rem = n % 10;
        reverseNumber = reverseNumber * 10 + rem;

        return reverse(n / 10,reverseNumber);
    }
}
