package com.anil.src;

public class FactorialParameterised {
    public static void main(String[] args) {
        int n = 4;
        fact(n,1);
    }

    private static void fact(int n, int product) {
        if (n < 1){
            System.out.println(product);
            return;
        }
        fact(n - 1,product * n);
    }
}
