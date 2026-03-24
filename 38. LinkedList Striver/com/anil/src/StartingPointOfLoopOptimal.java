package com.anil.src;

public class StartingPointOfLoopOptimal {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast){
                ListNode temp = head;
                while (temp != fast){
                    temp = temp.next;
                    fast = fast.next;
                }

                return temp;
            }
        }

        return null;
    }
}
