package com.anil.src.queue;

public class CustomQueue {

    protected int[] data;
    private static final int DEFAULT_SIZE = 10;
    int end = 0;

    public CustomQueue(){
        this(DEFAULT_SIZE);
    }

    public CustomQueue(int size){
        this.data = new int[size];
    }

    public void enqueue(int item){
        if (isFull()){
            System.out.println("queue is full");
        }
        data[end] = item;
        end++;
    }

    public int dequeue() throws Exception {
        if (isEmpty()){
            throw new Exception("queue is empty");
        }
        int removedItem = data[0];
        for (int i = 1; i < end; i++){
            data[i - 1] = data[i];
        }
        end--;
        return removedItem;
    }

    public int front() throws Exception {
        if (isEmpty()){
            throw new Exception("queue is empty");
        }
        return data[0];
    }

    public int size(){
        return end;
    }

    private boolean isEmpty() {
        return end == 0;
    }

    private boolean isFull() {
        return end == data.length;
    }
}
