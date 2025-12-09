package com.anil.src;

public class Name {
    public static void main(String[] args) {
        int n = 5;
        print(1,n);
    }

    private static void print(int i,int n) {
        if (i > n){
            return;
        }
        System.out.println("Anil");
        print(i + 1,n);
    }
}
