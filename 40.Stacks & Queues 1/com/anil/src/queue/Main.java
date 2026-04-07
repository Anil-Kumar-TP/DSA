package com.anil.src.queue;

public class Main {
    public static void main(String[] args) throws Exception {
        CustomQueue queue = new CustomQueue(5);
        queue.enqueue(12);
        queue.enqueue(32);
        queue.enqueue(10);
        queue.enqueue(19);
        queue.enqueue(2);

        System.out.println(queue.dequeue());
    }
}
