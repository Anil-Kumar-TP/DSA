package com.anil.src;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HashmapExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = readArray(sc);
        Map<Integer,Integer> freqMap = buildFrequencyMap(arr);
        printFrequencies(freqMap);
        processQueries(sc,freqMap);
    }

    private static int[] readArray(Scanner sc) {
        System.out.println("Enter the size of array");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            System.out.println("Enter the " + i + " th element");
            arr[i] = sc.nextInt();
        }
        return arr;
    }

    private static Map<Integer, Integer> buildFrequencyMap(int[] arr) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int value : arr){
            map.put(value, map.getOrDefault(value,0) + 1);
        }
        return map;
    }

    private static void processQueries(Scanner sc, Map<Integer, Integer> freqMap) {
        System.out.println("Enter the number of queries");
        int q = sc.nextInt();
        for (int i = 0; i < q; i++){
            System.out.println("Enter a number to check its frequency");
            int number = sc.nextInt();
            System.out.println("Frequency is " + freqMap.getOrDefault(number,0));
        }
    }

    private static void printFrequencies(Map<Integer, Integer> freqMap) {
        for (Map.Entry<Integer,Integer> entry : freqMap.entrySet()){
            int key = entry.getKey();
            int value = entry.getValue();
            System.out.println("Key is " + key + " and value is " + value);
        }
    }
}
