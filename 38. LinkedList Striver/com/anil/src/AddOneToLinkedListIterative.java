package com.anil.src;

public class AddOneToLinkedListIterative {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public ListNode addOne(ListNode head) {
        head = reverse(head);

        ListNode temp = head;
        int carry = 1;

        while (temp != null){
            int sum = temp.val + carry;
            temp.val = sum % 10;
            carry = sum / 10;

            if (carry == 0){
                break;
            }

            if (temp.next == null){
                temp.next = new ListNode(carry);
                carry = 0;
                break;
            }

            temp = temp.next;
        }

        head = reverse(head);
        return head;
    }

    private ListNode reverse(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {

            ListNode next = curr.next;

            curr.next = prev;

            prev = curr;
            curr = next;
        }

        return prev;
    }
}
