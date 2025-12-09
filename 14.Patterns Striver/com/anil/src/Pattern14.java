package com.anil.src;

public class Pattern14 {
    public static void main(String[] args) {
        int n = 5;
        print(n);
    }

    private static void print(int n) {
        for (int i = 1; i <= n; i++){
            for (char ch = 'A'; ch <= ('A' + i) - 1; ch++){
                System.out.print(ch + " ");
            }
            System.out.println();
        }
    }
}
