package com.anil.src.arraytoDLL;

public class ArrayToDoublyLinkedList {

    private Node head;
    private Node tail;


    private class Node{
        private int value;
        private Node prev;
        private Node next;

        public Node(int value){
            this.value = value;
        }

        public Node(int value,Node prev,Node next){
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }

    public void display(){
        System.out.println("FORWARD");
        Node temp = head;
        while (temp != null){
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("END");

        System.out.println("BACKWARD");
        temp = tail;
        while (temp != null){
            System.out.print(temp.value + " -> ");
            temp = temp.prev;
        }
        System.out.println("START");
    }

    public void fromArray(int[] arr){

        if (arr.length == 0){
            return;
        }

        head = new Node(arr[0]);
        tail = head;

        for (int i = 1; i < arr.length; i++){
            Node node = new Node(arr[i]);
            node.prev = tail;
            tail.next = node;
            tail = node;
        }
    }
}

class Main{
    public static void main(String[] args) {
        ArrayToDoublyLinkedList list = new ArrayToDoublyLinkedList();
        int[] arr = {1,3,2,9,10};
        list.fromArray(arr);
        list.display();
    }
}

