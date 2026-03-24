package com.anil.src;

public class DeleteAllOccurrenceOfKeyInSinglyLinkedList {

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

        ListNode(int data1, ListNode next1,ListNode prev1) {
            val = data1;
            next = next1;
            prev = prev1;
        }
    }

    public ListNode deleteAllOccurrences(ListNode head, int target) {
        ListNode curr = head;
        ListNode prev = null;

        while (curr != null){
            if (curr.val == target){
                if (curr == head){
                    head = curr.next;
                }else {
                    prev.next = curr.next;
                }
            }else {
                prev = curr;
            }

            curr = curr.next;
        }

        return head;
    }
}


//prev should only move when we keep the node.
//
//If we delete curr, we do not move prev.
//
//        Why? Because prev must still connect to the next valid node.