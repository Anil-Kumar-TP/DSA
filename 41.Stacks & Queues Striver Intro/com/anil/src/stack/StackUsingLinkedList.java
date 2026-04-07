package com.anil.src.stack;

public class StackUsingLinkedList {

    public class Node{
        private int value;
        private Node next;

        Node(int value){
            this.value = value;
        }
    }

    private Node top; //head
    private int size;

    public void push(int item){
        Node node = new Node(item);
        node.next = top;
        top = node;
        size++;
    }

    public int pop() throws Exception{
        if (isEmpty()){
            throw new Exception("stack is empty");
        }
        int removedItem = top.value;
        top = top.next;
        size--;
        return removedItem;
    }

    public int peek() throws Exception{
        if (isEmpty()){
            throw new Exception("stack is empty");
        }
        return top.value;
    }

    public boolean isEmpty(){
        return top == null;
    }

    public int size(){
        return size;
    }
}
