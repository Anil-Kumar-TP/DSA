package com.anil.src;

import java.util.HashSet;

public class RemoveDuplicatesFromUnsortedDLL {

    public class Node{
        int data;
        Node next, prev;
        Node(int x){
            this.data = x;
            this.next = null;
            this.prev = null;
        }
    }

    public Node removeDuplicatesUnsorted(Node head) {
        if (head == null) {
            return null;
        }

        HashSet<Integer> set = new HashSet<>();
        Node curr = head;
        while (curr != null) {
            if (set.contains(curr.data)){
                Node nextNode = curr.next;
                Node prevNode = curr.prev;

                if (prevNode != null) {
                    prevNode.next = nextNode;
                }

                if (nextNode != null){
                    nextNode.prev = prevNode;
                }

                curr = nextNode;
            }else {
                set.add(curr.data);
                curr = curr.next;
            }
        }

        return head;
    }
}
