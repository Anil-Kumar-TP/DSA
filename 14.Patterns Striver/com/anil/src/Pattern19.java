package com.anil.src;

public class Pattern19 {
    public static void main(String[] args) {
        int n = 5;
        print(n);
    }

    private static void print(int n) {
        int spaces = 0;
        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= n - i + 1; j++){
                System.out.print("*");
            }
            for (int j = 1; j <= spaces; j++){
                System.out.print(" ");
            }
            for (int j = 1; j <= n - i + 1; j++){
                System.out.print("*");
            }
            spaces = spaces + 2;
            System.out.println();
        }

        spaces = 2 * n - 2;
        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= i; j++){
                System.out.print("*");
            }
            for (int j = 1; j <= spaces; j++){
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++){
                System.out.print("*");
            }
            spaces = spaces - 2;
            System.out.println();
        }
    }
}
