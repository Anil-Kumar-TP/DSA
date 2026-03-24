package com.anil.src;

public class RemoveDuplicatesFromUnsortedSinglyLinkedListNoExtraSpace {

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

        Node curr = head;
        while (curr != null) {
            Node temp = curr;
            while (temp.next != null) {
                if (temp.next.data == curr.data) {
                    temp.next = temp.next.next;
                }else {
                    temp = temp.next;
                }
            }

            curr = curr.next;
        }

        return head;
    }
}
