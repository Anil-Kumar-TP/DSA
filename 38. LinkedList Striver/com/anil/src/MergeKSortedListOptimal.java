package com.anil.src;

import java.util.PriorityQueue;

public class MergeKSortedListOptimal {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);

        for (ListNode head : lists){
            if (head != null) {
                pq.add(head);
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        while (!pq.isEmpty()) {
            ListNode minNode = pq.poll();
            tail.next = minNode;
            tail = tail.next;

            if (minNode.next != null) {
                pq.add(minNode.next);
            }
        }

        return dummy.next;
    }
}
