package com.anil.src;

import java.util.Scanner;

public class Hashing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of the array");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++){
            System.out.println("Enter the " + i + " th element you want to insert to the array");
            arr[i] = sc.nextInt();
        }

        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++){
            if (arr[i] > maxValue){
                maxValue = arr[i];
            }
        }

        int[] freq = new int[maxValue + 1];
        for (int i = 0; i < arr.length; i++){
            int value = arr[i];
            freq[value]++;
        }

        System.out.println("Enter the number of queries");
        int q = sc.nextInt();
        for (int i = 0; i < q; i++){
            System.out.println("Enter the number whose frequency is to determined");
            int x = sc.nextInt();

            if (x > maxValue){
                System.out.println(0);
            }else {
                System.out.println("Frequency is "  + freq[x]);
            }
        }

    }
}


//        One scan to find max → O(n)
//
//        One scan to build freq[] → O(n)
//
//        Answer each query in O(1)
//        Total → O(n + q)
