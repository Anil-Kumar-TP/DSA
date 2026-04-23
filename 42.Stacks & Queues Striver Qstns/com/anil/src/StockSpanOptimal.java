package com.anil.src;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StockSpanOptimal {

    List<Integer> prices;
    Stack<Integer> stack;
    int currentIndex;

    public StockSpanOptimal(){
        prices = new ArrayList<>();
        stack = new Stack<>();
        currentIndex = 0;
    }

    public int next(int price){
        // While top is smaller or equal, it's not a "Greater" element
        while (!stack.isEmpty() && prices.get(stack.peek()) <= price) {
            stack.pop();
        }

        int pgeIndex = stack.isEmpty() ? -1 : stack.peek();
        int span = currentIndex - pgeIndex;

        prices.add(price);
        stack.push(currentIndex);
        currentIndex++;

        return span;
    }
}

//for loop in the pattern is replaced by next here.