package com.anil.src;

public class LengthOfLoopOptimal {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public int lengthOfLoop(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast){
                return findLength(slow,fast);
            }
        }
        return 0;
    }

    private int findLength(ListNode slow, ListNode fast) {
        int count = 1;
        fast = fast.next;
        while (slow != fast){
            count++;
            fast = fast.next;
        }
        return count;
    }
}
