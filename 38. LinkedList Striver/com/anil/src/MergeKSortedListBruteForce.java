package com.anil.src;

import java.util.ArrayList;
import java.util.Collections;

public class MergeKSortedListBruteForce {

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeKLists(ListNode[] lists) {

        ArrayList<Integer> list = new ArrayList<>();

        for (ListNode head : lists){
            ListNode temp = head;
            while (temp != null) {
                list.add(temp.val);
                temp = temp.next;
            }
        }

        Collections.sort(list);

        ListNode dummy = new ListNode();
        ListNode tail = dummy;

        for (int val : list){
            tail.next = new ListNode(val);
            tail = tail.next;
        }

        return dummy.next;
    }
}
