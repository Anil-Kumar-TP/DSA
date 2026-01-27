package com.anil.src.circularlinkedlist;

public class CircularLinkedList {

    private Node head;
    private Node tail;

    public CircularLinkedList(){
        this.head = null;
        this.tail = null;
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
        if (head != null){
            do {
                System.out.print(temp.value + " -> ");
                temp = temp.next;
            }while (temp != head);
        }
        System.out.println("HEAD");
    }

    public void insert(int value){
        Node node = new Node(value);
        if (head == null){
            head = node;
            tail = node;
            return;
        }
        tail.next = node;
        node.next = head;
        tail = node;
    }

    public void delete(int value){
        Node temp = head;
        if (temp == null){
            return;
        }
        if (temp.value == value){
            head = head.next;
            tail.next = head;
            return;
        }

        do{
            Node n = temp.next;
            if (n.value == value){
                temp.next = n.next;
                break;
            }
            temp = temp.next;
        }while (temp != head);
    }
}
