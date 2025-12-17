package com.anil.src;

public class BuyAndSellStockOptimal {
    public static void main(String[] args) {
        int[] arr = {7,1,5,3,6,4};
        int ans = maxProfit(arr);
        System.out.println(ans);
    }

    private static int maxProfit(int[] arr) {
        int minimumPrice = arr[0];
        int maxProfit = 0;
        for (int i = 1; i < arr.length; i++){
            int profitToday = arr[i] - minimumPrice;
            maxProfit = Math.max(maxProfit,profitToday);
            minimumPrice = Math.min(minimumPrice,arr[i]);
        }
        return maxProfit;
    }
}
//
//
//“Buying at 7 and selling at 1 is stupid.
//Update minimumPrice to 1 and try again.”