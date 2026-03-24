package com.anil.src;

import java.util.HashSet;

public class RemoveDuplicatesFromUnsortedSinglyLinkedList {

    public class Node{
        int data;
        Node next, prev;
        Node(int x){
            this.data = x;
            this.next = null;
            this.prev = null;
        }
    }

    public Node removeDuplicatesSingly(Node head) {
        if (head == null) {
            return null;
        }

        HashSet<Integer> set = new HashSet<>();

        Node curr = head;
        Node prev = null;

        while (curr != null) {
            if (set.contains(curr.data)){
                prev.next = curr.next;
            }else {
                set.add(curr.data);
                prev = curr;
            }

            curr = curr.next;
        }

        return head;
    }
}
