package com.anil.src;

import java.util.HashMap;

public class RemoveAllDuplicatesFromUnsortedSinglyLinkedList {

    public class Node {
        int data;
        Node next, prev;

        Node(int x) {
            this.data = x;
            this.next = null;
            this.prev = null;
        }
    }

    public Node deleteDuplicates(Node head) {
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

        Node prev = dummy;
        curr = head;

        while (curr != null) {
            if (map.get(curr.data) > 1) {
                prev.next = curr.next;
            }else {
                prev = curr;
            }

            curr = curr.next;
        }

        return dummy.next;
    }
}
