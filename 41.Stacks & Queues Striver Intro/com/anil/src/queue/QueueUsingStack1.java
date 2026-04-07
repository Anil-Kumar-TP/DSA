package com.anil.src.queue;

import java.util.Stack;

public class QueueUsingStack1 {

    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    public void enqueue(int item){
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }

        stack1.push(item);

        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
    }

    public int peek(){
        return stack1.peek();
    }

    public int dequeue(){
        return stack1.pop();
    }
}
