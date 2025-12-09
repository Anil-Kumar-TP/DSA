package com.anil.src;

public class FactorialParameterisedOther {
    public static void main(String[] args) {
        int n = 4;
        fact(1,n,1);
    }

    private static void fact(int i, int n, int product) {
        if (i > n){
            System.out.println(product);
            return;
        }
        fact(i + 1,n,product * i);
    }
}
