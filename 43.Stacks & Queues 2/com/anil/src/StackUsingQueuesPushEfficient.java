package com.anil.src;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueuesPushEfficient {

    private Queue<Integer> queue;

    public StackUsingQueuesPushEfficient(){
        queue = new LinkedList<>();
    }

    public void push(int x){
        queue.offer(x);
    }

    public int pop(){
        for (int i = 0; i < queue.size() - 1; i++){
            queue.offer(queue.poll());
        }

        return queue.poll();
    }

    public int peek(){
        for (int i = 0; i < queue.size() - 1; i++){
            queue.offer(queue.poll());
        }

        int result = queue.poll();
        queue.offer(queue.poll());
        return result;
    }

    public boolean isEmpty(){
        return queue.isEmpty();
    }
}
