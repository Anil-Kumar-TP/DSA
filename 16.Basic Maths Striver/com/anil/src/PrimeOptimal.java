package com.anil.src;

public class PrimeOptimal {
    public static void main(String[] args) {
        int n = 13;
        boolean ans = isPrime(n);
        System.out.println(ans);
    }

    private static boolean isPrime(int n) {
        int count = 0;
        for (int i = 1; i * i <= n; i++){
            if (n % i == 0){
                count++;
                if (n / i != i){
                    count++;
                }
            }
        }
        return count == 2;
    }
}
