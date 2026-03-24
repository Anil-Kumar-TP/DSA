package com.anil.src;

public class AddTwoNumbers2Reverse {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode addTwoNumbers(ListNode l1,ListNode l2){
        ListNode rev1 = reverse(l1);
        ListNode rev2 = reverse(l2);

        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        int carry = 0;

        while (rev1 != null || rev2 != null || carry != 0) {
            int sum = carry;

            if (rev1 != null) {
                sum += rev1.val;
                rev1 = rev1.next;
            }
            if (rev2 != null) {
                sum += rev2.val;
                rev2 = rev2.next;
            }

            carry = sum / 10;
            temp.next = new ListNode(sum % 10);
            temp = temp.next;
        }

        ListNode result = reverse(dummy.next);

        return result;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
}
