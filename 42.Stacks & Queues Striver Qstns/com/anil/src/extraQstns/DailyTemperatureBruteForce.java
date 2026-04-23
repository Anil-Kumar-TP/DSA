package com.anil.src.extraQstns;

import java.util.Arrays;

public class DailyTemperatureBruteForce {
    public static void main(String[] args) {
        int[] temperatures = {73,74,75,71,69,72,76,73};
        int[] ans = dailyTemperatures(temperatures);
        System.out.println(Arrays.toString(ans));
    }

    private static int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++){
            result[i] = 0;
            for (int j = i + 1; j < temperatures.length; j++){
                if (temperatures[j] > temperatures[i]){
                    result[i] = j - i;
                    break;
                }
            }
        }
        return result;
    }
}
