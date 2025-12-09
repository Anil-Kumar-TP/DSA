package com.anil.src;

public class PrintNto1 {
    public static void main(String[] args) {
        int n = 10;
        print(n);
    }

    private static void print(int n) {
        if (n < 1){
            return;
        }
        System.out.print(n + " ");
        print(n - 1);
    }
}
