package com.anil.src;

public class ReverseDoublyLinkedListOptimal {

    public class Node{
        private int val;
        private Node next;
        private Node prev;

        public Node(int val) {
            this.val = val;
        }

        public Node(Node prev, int val, Node next) {
            this.prev = prev;
            this.val = val;
            this.next = next;
        }
    }

    public Node reverseDoublyLinkedList(Node head){
        Node current = head;
        Node last = null;

        while (current != null){
            Node temp = current.next;
            current.next = current.prev;
            current.prev = temp;
            last = current;
            current = temp;
        }

        return last;
    }
}
