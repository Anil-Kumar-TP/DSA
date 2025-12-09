package com.anil.src;

public class Pattern2 {
    public static void main(String[] args) {
        int n = 5;
        print(n);
    }

    private static void print(int n) {
        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= i; j++){
                System.out.print(" * ");
            }
            System.out.println();
        }
    }
}
