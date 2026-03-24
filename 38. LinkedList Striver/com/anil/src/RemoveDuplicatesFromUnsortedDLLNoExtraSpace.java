package com.anil.src;

public class RemoveDuplicatesFromUnsortedDLLNoExtraSpace {

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

        Node temp1 = head;
        while (temp1 != null) {
            Node temp2 = temp1.next;
            while (temp2 != null) {
                if (temp1.data == temp2.data) {
                    Node nextNode = temp2.next;
                    Node prevNode = temp2.prev;

                    if (prevNode != null) {
                        prevNode.next = nextNode;
                    }

                    if (nextNode != null) {
                        nextNode.prev = prevNode;
                    }

                    temp2 = nextNode;
                }else {
                    temp2 = temp2.next;
                }
            }

            temp1 = temp1.next;
        }

        return head;
    }
}
