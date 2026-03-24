package com.anil.src;

public class DeleteAllOccurrenceOfKeyInDLL {

    public class ListNode {
        int val;
        ListNode next;
        ListNode prev;

        ListNode() {
            val = 0;
            next = null;
            prev = null;
        }

        ListNode(int data1) {
            val = data1;
            next = null;
            prev = null;
        }

        ListNode(int data1, ListNode next1, ListNode prev1) {
            val = data1;
            next = next1;
            prev = prev1;
        }
    }

    public ListNode deleteAllOccurrences(ListNode head, int target) {
        ListNode curr = head;

        while (curr != null) {

            if (curr.val == target) {

                ListNode prev = curr.prev;
                ListNode next = curr.next;

                // deleting head
                if (prev == null) {
                    head = next;
                } else {
                    prev.next = next;
                }

                // updating next node
                if (next != null) {
                    next.prev = prev;
                }
            }

            curr = curr.next;
        }

        return head;
    }
}
