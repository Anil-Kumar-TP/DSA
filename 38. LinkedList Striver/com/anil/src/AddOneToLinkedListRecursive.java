package com.anil.src;

public class AddOneToLinkedListRecursive {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public ListNode addOne(ListNode head) {
        int carry = helper(head);

        if (carry == 1){
            ListNode newNode = new ListNode(1);
            newNode.next = head;
            return newNode;
        }

        return head;
    }

    private int helper(ListNode head) {
        if (head == null){
            return 1;
        }

        int carry = helper(head.next);
        int sum = head.val + carry;
        head.val = sum % 10;
        return sum / 10;
    }
}
