package com.anil.src;

public class Sum1toNFunctional {
    public static void main(String[] args) {
        int n = 5;
        int ans = print(n);
        System.out.println(ans);
    }

    private static int print(int n) {
        if (n == 0){
            return 0;
        }
        return n + print(n - 1);
    }
}
