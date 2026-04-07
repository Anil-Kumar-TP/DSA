package com.anil.src.queue;

public class QueueUsingLinkedList {

    public class Node{
        private Node next;
        private int value;

        Node(int value){
            this.value = value;
        }
    }

    private Node start;
    private Node end;
    private int size;

    public void enqueue(int item){
        Node node = new Node(item);
        if (end == null) { //empty queue
            start = end = node;
        }else {
            end.next = node;
            end = node;
        }
        size++;
    }

    public int dequeue() throws Exception{
        if (isEmpty()){
            throw new Exception("queue is empty");
        }
        int removedItem = start.value;
        start = start.next;
        if (start == null) {
            end = null;
        }
        size--;
        return removedItem;
    }

    public int front() throws Exception{
        if (isEmpty()){
            throw new Exception("queue is empty");
        }

        return start.value;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return start == null;
    }
}
