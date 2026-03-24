package com.anil.src;

public class AddTwoNumbers {

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        int carry = 0;

        while (l1 != null || l2 != null || carry != 0){
            int sum = 0;

            if (l1 != null){
                sum = sum + l1.val;
                l1 = l1.next;
            }

            if (l2 != null){
                sum = sum + l2.val;
                l2 = l2.next;
            }

            sum = sum + carry;

           int digitToWrite = sum % 10;
            carry = sum / 10;

            ListNode newNode = new ListNode(digitToWrite);

            temp.next = newNode;
            temp = temp.next;
        }
        return dummy.next;
    }
}
