package com.anil.src;

public class LCMBruteForce {
    public static void main(String[] args) {
        int num1 = 4;
        int num2 = 6;
        int ans = lcm(num1,num2);
        System.out.println(ans);
    }

    private static int lcm(int num1, int num2) {
        int i = Math.max(num1,num2);
        while (true){
            if (i % num1 == 0 && i % num2 == 0){
                return i;
            }
            i++;
        }
    }
}

//“The first number where both numbers meet when they keep taking multiples.”
//
//        Example:
//        For 4 and 6:
//
//        Multiples of 4 → 4, 8, 12, 16, 20, 24 …
//
//        Multiples of 6 → 6, 12, 18, 24 …
//
//        They meet first at 12.
//        So LCM = 12.
//
//        That’s it — this is the raw intuition.
//    Because LCM can never be smaller than the bigger number.