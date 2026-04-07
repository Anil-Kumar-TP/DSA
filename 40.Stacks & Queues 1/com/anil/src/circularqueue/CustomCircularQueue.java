package com.anil.src.circularqueue;

public class CustomCircularQueue {

    protected int[] data;
    private static final int DEFAULT_SIZE = 10;
    private int front = 0;
    private int end = 0;
    private int size = 0;

    public CustomCircularQueue(){
        this(DEFAULT_SIZE);
    }

    public CustomCircularQueue(int size){
        this.data = new int[size];
    }

    public void enqueue(int item){
        if (isFull()){
            System.out.println("queue is full");
        }
        data[end] = item;
        end = (end + 1) % data.length;
        size++;
    }

    public int dequeue() throws Exception {
        if (isEmpty()){
            throw new Exception("queue is empty");
        }

        int removedItem = data[front];
        front = (front + 1) % data.length;
        size--;
        return removedItem;
    }

    public int front() throws Exception {
        if (isEmpty()){
            throw new Exception("queue is empty");
        }
        return data[front];
    }

    private boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull(){
        return size == data.length;
    }

    public int size(){
        return size;
    }

    public void display(){
        if (isEmpty()){
            System.out.println("queue is empty");
        }
        int i = front;
        do{
            System.out.print(data[i] + " ");
            i = (i + 1) % data.length;
        }while (i != end);
        System.out.println();
    }
}
