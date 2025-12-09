package com.anil.src;

import java.util.ArrayList;
import java.util.List;

public class PrintDivisorsBruteForce {
    public static void main(String[] args) {
        int n = 36;
        List<Integer> ans = divisors(n);
        System.out.println(ans);
    }

    private static List<Integer> divisors(int n) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i <= n; i++){
            if (n % i == 0){
                ans.add(i);
            }
        }
        return ans;
    }
}
