package com.anil.src;

public class Pattern17 {
    public static void main(String[] args) {
        int n = 5;
        print(n);
    }

    private static void print(int n) {
        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= n - i; j++){
                System.out.print(" ");
            }
            char ch = 'A';
            int breakPoint = (2 * i - 1) / 2;
            for (int j = 1; j <= 2 * i - 1; j++){
                System.out.print(ch);
                if (j <= breakPoint){
                    ch++;
                }else {
                    ch--;
                }
            }
            for (int j = 1; j <= n - i; j++){
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
