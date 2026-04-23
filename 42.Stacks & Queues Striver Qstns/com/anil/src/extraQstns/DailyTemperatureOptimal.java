package com.anil.src.extraQstns;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatureOptimal {
    public static void main(String[] args) {
        int[] temperatures = {73,74,75,71,69,72,76,73};
        int[] ans = dailyTemperatures(temperatures);
        System.out.println(Arrays.toString(ans));
    }

    private static int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = temperatures.length - 1; i >= 0; i--){
            while (!stack.isEmpty() && temperatures[i] >= temperatures[stack.peek()]){
                stack.pop();
            }

            if (!stack.isEmpty()){
                result[i] = stack.peek() - i;
            }

            stack.push(i);
        }

        return result;
    }
}
