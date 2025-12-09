package com.anil.src;

public class Print1toN {
    public static void main(String[] args) {
        int n = 10;
        print(1,n);
    }

    private static void print(int i, int n) {
        if (i > n){
            return;
        }
        System.out.print(i + " ");
        print(i + 1,n);
    }
}
