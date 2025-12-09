package com.anil.src;

public class PrintNto1Other {
    public static void main(String[] args) {
        int n = 10;
        print(1,n);
    }

    private static void print(int i, int n) {
        if (i > n){
            return;
        }
        print(i + 1,n);
        System.out.print(i + " ");
    }
}
