package com.anil.src.linkedlist;

public class LinkedList {

    private Node head;
    private Node tail;
    private int size;

    public LinkedList(){
        this.size = 0;
    }

    private class Node{
        private int value;
        private Node next;

        public Node(int value){
            this.value = value;
        }

        public Node(int value,Node next){
            this.value = value;
            this.next = next;
        }
    }

    public void display(){
        Node temp = head;
        while (temp != null){
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    public void insertAtFirst(int value){
        Node node = new Node(value);
        node.next = head;
        head = node;

        if (tail == null){
            tail = head;
        }
        size++;
    }

    public void insertAtLast(int value){
        if (tail == null){
            insertAtFirst(value);
            return;
        }
        Node node = new Node(value);
        tail.next = node;
        tail = node;
        size++;
    }

    public void insertAtIndex(int value,int index){
        if (index == 0){
            insertAtFirst(value);
            return;
        }

        if (index == size){
            insertAtLast(value);
            return;
        }

        Node temp = head;
        for (int i = 1; i < index; i++){
            temp = temp.next;
        }

        Node node = new Node(value,temp.next);
        temp.next = node;
        size++;
    }

    public int deleteFromFirst(){
        int value = head.value;
        head = head.next;
        if (head == null){
            tail = null;
        }
        size--;
        return value;
    }

    public int deleteFromLast(){
        if (size == 1){
          return deleteFromFirst();
        }

        Node temp = head;
        while (temp.next != tail){
            temp = temp.next;
        }
        int value = tail.value;
        tail = temp;
        tail.next = null;
        size--;
        return value;
    }

    public int deleteFromAnIndex(int index){
        if (index == 0){
            return deleteFromFirst();
        }
        if (index == size - 1){
            return deleteFromLast();
        }
        Node temp = head;
        for (int i = 1; i < index; i++){
            temp = temp.next;
        }
        int value = temp.next.value;
        temp.next = temp.next.next;
        size--;
        return value;
    }

    public Node find(int value){
        Node temp = head;
        while (temp != null){
            if (temp.value == value){
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }
}
