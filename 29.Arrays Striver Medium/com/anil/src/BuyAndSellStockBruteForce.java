package com.anil.src;

public class BuyAndSellStockBruteForce {
    public static void main(String[] args) {
        int[] arr = {7,1,5,3,6,4};
        int ans = maxProfit(arr);
        System.out.println(ans);
    }

    private static int maxProfit(int[] arr) {
        int maxProfit = 0;
        for (int i = 0; i < arr.length; i++){
            for (int j = i + 1; j < arr.length; j++){
                int profit = arr[j] - arr[i];
                if (profit > maxProfit){
                    maxProfit = profit;
                }
            }
        }
        return maxProfit;
    }
}
