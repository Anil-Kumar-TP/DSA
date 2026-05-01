package com.anil.src;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueuesPopEfficient {

    private Queue<Integer> queue;

    public StackUsingQueuesPopEfficient(){
        queue = new LinkedList<>();
    }

    public void push(int x){
        queue.offer(x);
        for (int i = 0; i < queue.size() - 1; i++){
            queue.offer(queue.poll());
        }
    }

    public int pop(){
        return queue.poll();
    }

    public int peek(){
        return queue.peek();
    }

    public boolean isEmpty(){
        return queue.isEmpty();
    }
}
