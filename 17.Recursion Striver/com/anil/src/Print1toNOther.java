package com.anil.src;

public class Print1toNOther {
    public static void main(String[] args) {
        int n = 10;
        print(n);
    }

    private static void print(int n) {
        if (n < 1){
            return;
        }
        print(n - 1);
        System.out.print(n + " ");
    }
}
