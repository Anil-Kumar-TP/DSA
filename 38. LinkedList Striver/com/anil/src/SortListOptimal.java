package com.anil.src;

public class SortListOptimal {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode middle = findMiddle(head);
        ListNode right = middle.next;
        middle.next = null;
        ListNode left = head;


        left = sortList(left);
        right = sortList(right);
        return merge(left,right); //here we need return but in arrays we don't
    }

    private ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public ListNode merge(ListNode list1, ListNode list2) {
        ListNode temp1 = list1;
        ListNode temp2 = list2;

        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        while (temp1 != null && temp2 != null) {
            if (temp1.val < temp2.val) {
                temp.next = temp1;
                temp1 = temp1.next;
            }else {
                temp.next = temp2;
                temp2 = temp2.next;
            }

            temp = temp.next;
        }

        if (temp1 != null) {
            temp.next = temp1;
        }

        if (temp2 != null) {
            temp.next = temp2;
        }

        return dummy.next;
    }
}
