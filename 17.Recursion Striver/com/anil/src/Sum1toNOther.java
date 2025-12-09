package com.anil.src;

public class Sum1toNOther {
    public static void main(String[] args) {
        int n = 5;
        print(1,n,0);
    }

    private static void print(int i,int n, int sum) {
        if (i > n){
            System.out.println(sum);
            return;
        }
        print(i + 1,n,sum + i);
    }
}
