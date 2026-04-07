package com.anil.src.stack;

public class CustomStackFixedSize {
    protected int[] data;
    private static final int DEFAULT_SIZE = 10;
    int ptr = -1;

    public CustomStackFixedSize(){
        this(DEFAULT_SIZE);
    }

    public CustomStackFixedSize(int size) {
        this.data = new int[size];
    }

    public void push(int item){
        if (isFull()) {
            System.out.println("stack is full");
        }

        ptr++;
        data[ptr] = item;
    }

    public int pop() throws StackException {
        if (isEmpty()) {
            throw new StackException("cannot pop from an empty stack");
        }
        int removedItem = data[ptr]; //remove from the end where the ptr ended.
        ptr--;
        return removedItem;
    }

    public int peek() throws StackException {
        if (isEmpty()) {
            throw new StackException("cannot peek from an empty stack");
        }
        return data[ptr];
    }

    public int size(){
        return ptr + 1;
    }

    public boolean isFull() {
        return ptr == data.length - 1;
    }

    public boolean isEmpty(){
        return ptr == -1;
    }
}

