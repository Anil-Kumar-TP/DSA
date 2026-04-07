package com.anil.src.stack;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {

    private Queue<Integer> queue = new LinkedList<>();

    public void push(int item){
        queue.add(item);
        int size = queue.size();
        for (int i = 0; i < size - 1; i++){
            queue.add(queue.remove());
        }
    }

    public int pop(){
        return queue.remove();
    }

    public int top(){
        return queue.peek();
    }

    public int size(){
        return queue.size();
    }
}
