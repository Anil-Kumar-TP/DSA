package com.anil.src.circularqueue;

public class Main {
    public static void main(String[] args) throws Exception {
        CustomCircularQueue queue = new CustomCircularQueue(5);
        queue.enqueue(12);
        queue.enqueue(10);
        queue.enqueue(2);
        queue.enqueue(29);
        queue.enqueue(31);

        queue.display();

        System.out.println(queue.dequeue());

        queue.display();
    }
}
