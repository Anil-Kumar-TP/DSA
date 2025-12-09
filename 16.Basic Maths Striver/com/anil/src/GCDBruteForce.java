package com.anil.src;

public class GCDBruteForce {
    public static void main(String[] args) {
        int num1 = 20;
        int num2 = 40;
        int ans = gcd(num1,num2);
        System.out.println(ans);
    }

    private static int gcd(int num1, int num2) {
        int gcd = 1;
        for (int i = 1; i <= Math.min(num1,num2); i++){
            if (num1 % i == 0 && num2 % i == 0){
                gcd = i;
            }
        }
        return gcd;
    }
}
