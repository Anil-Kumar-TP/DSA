package com.anil.src;

public class LCMOptimal {
    public static void main(String[] args) {
        int num1 = 4;
        int num2 = 6;
        int ans = lcm(num1,num2);
        System.out.println(ans);
    }

    private static int lcm(int num1, int num2) {
        int gcd = gcd(num1,num2);
        return num1 * num2 / gcd;
    }

    private static int gcd(int num1, int num2) {
        num1 = Math.abs(num1);
        num2 = Math.abs(num2); // to handle negatives
        if (num1 == 0 && num2 == 0){
            throw new IllegalArgumentException("Gcd do not exist");
        }
        if (num1 == 0) return num2;//avoid division by zero
        if (num2 == 0) return num1;
        while (num1 > 0 && num2 > 0){
            if (num1 > num2){
                num1 = num1 % num2;
            }else {
                num2 = num2 % num1;
            }
        }
        if (num1 == 0){
            return num2;
        }else {
            return num1;
        }
    }
}
