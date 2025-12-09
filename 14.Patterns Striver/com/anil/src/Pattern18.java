package com.anil.src;

public class Pattern18 {
    public static void main(String[] args) {
        int n = 5;
        print(n);
    }

    private static void print(int n) {
        for (int i = 1; i <= n; i++){
            for (char ch = (char) ('E' - i + 1); ch <= 'E'; ch++){
                System.out.print(ch + " ");
            }
            System.out.println();
        }
    }
}
