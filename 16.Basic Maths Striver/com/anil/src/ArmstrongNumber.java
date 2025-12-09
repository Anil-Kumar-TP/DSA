package com.anil.src;

public class ArmstrongNumber {
    public static void main(String[] args) {
        int n = 371;
        boolean ans = isArmstrong(n);
        System.out.println(ans);
    }

    private static boolean isArmstrong(int n) {
        int originalNumber = n;
        int digits = (int) (Math.log10(n) + 1);
        int sum = 0;
        while (n > 0){
            int lastDigit = n % 10;
            sum = (int) (sum + Math.pow(lastDigit, digits));
            n = n / 10;
        }
        return originalNumber == sum;
    }
}
