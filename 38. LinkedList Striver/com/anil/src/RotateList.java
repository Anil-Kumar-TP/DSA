package com.anil.src;

public class RotateList {

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        //we are not using length as 0 here,cus we also need tail node here .
        //if it was just the length of node we need,we could use 0,but we need the tail to connect.
        ListNode temp = head;
        int length = 1;
        while (temp.next != null) {
            temp = temp.next;
            length++;
        }

        k = k % length;

        temp.next = head;

        int stepsToNewTail = length - k;
        ListNode newTail = head;

        for (int i = 1; i < stepsToNewTail; i++){
            newTail = newTail.next;
        }

        head = newTail.next;
        newTail.next = null;

        return head;
    }
}
