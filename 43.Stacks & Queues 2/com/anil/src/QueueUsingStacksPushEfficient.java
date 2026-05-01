package com.anil.src;

import java.util.Stack;

public class QueueUsingStacksPushEfficient {

    private Stack<Integer> first;
    private Stack<Integer> second;

    public QueueUsingStacksPushEfficient(){
        first = new Stack<>();
        second = new Stack<>();
    }

    public void push(int x){
        first.push(x);
    }

    public int pop(){
        if (second.isEmpty()) {
            while (!first.isEmpty()) {
                second.push(first.pop());
            }
        }
        return second.pop();
    }

    public int peek(){
        if (second.isEmpty()) {
            while (!first.isEmpty()) {
                second.push(first.pop());
            }
        }
        return second.peek();
    }

    public boolean isEmpty(){
        return first.isEmpty() && second.isEmpty();
    }
}
