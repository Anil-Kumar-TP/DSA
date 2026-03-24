package com.anil.src;

import java.util.HashMap;

public class RemoveAllDuplicatesFromUnsortedDLL {

    public class Node{
        int data;
        Node next, prev;
        Node(int x){
            this.data = x;
            this.next = null;
            this.prev = null;
        }
    }

    public Node removeAllDuplicates(Node head) {
        if (head == null) {
            return null;
        }

        HashMap<Integer,Integer> map = new HashMap<>();

        Node curr = head;
        while (curr != null) {
            map.put(curr.data,map.getOrDefault(curr.data,0) + 1);
            curr = curr.next;
        }

        Node dummy = new Node(-1);
        dummy.next = head;
        head.prev = dummy;

        curr = head;
        while (curr != null) {
            Node nextNode = curr.next;
            if (map.get(curr.data) > 1) {
                Node prevNode = curr.prev;
                prevNode.next = nextNode;

                if (nextNode != null) {
                    nextNode.prev = prevNode;
                }
            }

            curr = nextNode;
        }

        Node newHead = dummy.next;
        if (newHead != null) {
            newHead.prev = null;
        }

        return newHead;
    }
}
