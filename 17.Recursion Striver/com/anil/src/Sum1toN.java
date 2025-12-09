package com.anil.src;

public class Sum1toN {
    public static void main(String[] args) {
       print(5,0);
    }

    private static void print(int n, int sum) {
        if (n < 1){
            System.out.print(sum);
            return;
        }
        print(n - 1,sum + n);
    }
}
