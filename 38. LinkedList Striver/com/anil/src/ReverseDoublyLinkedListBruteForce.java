package com.anil.src;

import java.util.Stack;

public class ReverseDoublyLinkedListBruteForce {

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
        if (head == null || head.next == null){
            return head;
        }

        Stack<Integer> stack = new Stack<>();

        Node temp = head;

        while (temp != null){
            stack.push(temp.val);
            temp = temp.next;
        }

        temp = head;
        while (temp != null){
            temp.val = stack.pop();
            temp = temp.next;
        }

        return head;
    }
}
