package com.anil.src;

import java.util.ArrayList;
import java.util.List;

public class StockSpanBruteForce {

    List<Integer> prices;

    public StockSpanBruteForce(){
        prices = new ArrayList<>();
    }

    public int next(int price){
        prices.add(price);
        int count = 1;

        for (int i = prices.size() - 2; i >= 0; i--){
            if (prices.get(i) <= price){
                count++;
            }else {
                break;
            }
        }

        return count;
    }
}
