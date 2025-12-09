package com.anil.src;

public class Pattern1 {
    public static void main(String[] args) {
        int n = 5;
        print(1,n);
    }

    private static void print(int row,int n) {

        if (row > n){
            return;
        }

        printStars(n - row + 1);
        System.out.println();
        print(row + 1,n);
    }

    private static void printStars(int count) {
        if (count == 0){
            return;
        }
        System.out.print(" * ");
        printStars(count - 1);
    }
}
