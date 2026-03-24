package com.anil.src;

public class RemoveAllDuplicatesFromSortedSinglyLinkedList {

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

        Node dummy = new Node(-1);
        dummy.next = head;

        Node prev = dummy;
        Node curr = head;

        while (curr != null) {
            boolean isDuplicate = false;
            while (curr.next != null && curr.data == curr.next.data) {
                isDuplicate = true;
                curr = curr.next;
            }

            if (isDuplicate) {
                prev.next = curr.next;
            }else{
                prev = prev.next;
            }

            curr = curr.next;
        }

        return dummy.next;
    }
}
