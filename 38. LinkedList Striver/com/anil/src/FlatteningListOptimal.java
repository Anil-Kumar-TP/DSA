package com.anil.src;


public class FlatteningListOptimal {

    public class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    };

    public Node flatten(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node mergedHead = flatten(head.next);
        head = merge(head,mergedHead);
        return head;
    }

    private Node merge(Node list1, Node list2) {
        Node dummy = new Node();
        Node temp = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                temp.child = list1;
                list1 = list1.next;
            }else {
                temp.child = list2;
                list2 = list2.next;
            }

            temp = temp.child;
        }

        if (list1 != null) {
            temp.child = list1;
        }

        if (list2 != null) {
            temp.child = list2;
        }

        return dummy.child;
    }

}
