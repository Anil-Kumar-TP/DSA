package com.anil.src;

public class RemoveDuplicatesFromSortedDLL {

    public class Node{
        int data;
        Node next, prev;
        Node(int x){
            this.data = x;
            this.next = null;
            this.prev = null;
        }
    }

    public Node removeDuplicates(Node head) {
        if (head == null){
            return null;
        }

        Node curr = head;
        while (curr != null && curr.next != null){
            if (curr.data == curr.next.data){
                Node nextNode = curr.next;
                curr.next = nextNode.next;

                if (nextNode.next != null){
                    nextNode.next.prev = curr;
                }
            }else {
                curr = curr.next;
            }
        }

        return head;
    }
}
