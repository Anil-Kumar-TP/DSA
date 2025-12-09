package com.anil.src;

public class GCDBetter {
    public static void main(String[] args) {
        int num1 = 20;
        int num2 = 40;
        int ans = gcd(num1,num2);
        System.out.println(ans);
    }

    private static int gcd(int num1, int num2) {
        for (int i = Math.min(num1,num2); i > 0; i--){
            if (num1 % i == 0 && num2 % i == 0){
                return i;
            }
        }
        return 1;
    }
}
