package com.anil.src;

import java.util.Stack;

public class QueueUsingStacksPopEfficient {

    private Stack<Integer> first;
    private Stack<Integer> second;

    public QueueUsingStacksPopEfficient(){
        first = new Stack<>();
        second = new Stack<>();
    }

    public void push(int x){
        while (!first.isEmpty()) {
            second.push(first.pop());
        }
        first.push(x);

        while (!second.isEmpty()) {
            first.push(second.pop());
        }
    }

    public int pop(){
        return first.pop();
    }

    public int peek(){
        return first.peek();
    }

    public boolean isEmpty(){
        return first.isEmpty() && second.isEmpty();
    }
}
