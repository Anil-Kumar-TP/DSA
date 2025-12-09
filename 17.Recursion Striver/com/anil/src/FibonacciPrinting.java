package com.anil.src;

public class FibonacciPrinting {
    public static void main(String[] args) {
        fib(10,0,1);
    }

    private static void fib(int n, int prev, int curr) {
        if (n == 0){
            return;
        }
        System.out.println(prev);
        fib(n - 1,curr,prev + curr);
    }
}

//    void printFib(int n, int i, int a, int b) {
//        if (i > n) return;
//
//        System.out.print(a + " ");
//
//        printFib(n, i + 1, b, a + b);
//    }
