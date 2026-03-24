package com.anil.src;

public class RemoveAllDuplicatesFromSortedDLL {

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

        Node dummy = new Node(-1);
        dummy.next = head;
        head.prev = dummy;

        Node prev = dummy;
        Node curr = head;

        while (curr != null) {
            boolean isDuplicate = false;

            while (curr.next != null && curr.data == curr.next.data){
                isDuplicate = true;
                curr = curr.next;
            }

            if (isDuplicate){
                curr = curr.next;
                prev.next = curr;
                if (curr != null) {
                    curr.prev = prev;
                }
            }else {
                prev = curr;
                curr = curr.next;
            }
        }

        return dummy.next;
    }
}
