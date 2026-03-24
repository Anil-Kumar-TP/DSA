package com.anil.src;

import java.util.ArrayList;
import java.util.Collections;

public class MergeTwoSortedListBruteForce {

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode temp1 = list1;
        ListNode temp2 = list2;

        ArrayList<Integer> list = new ArrayList<>();

        while (temp1 != null) {
            list.add(temp1.val);
            temp1 = temp1.next;
        }

        while (temp2 != null) {
            list.add(temp2.val);
            temp2 = temp2.next;
        }

        Collections.sort(list);

        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        for (int val : list){
            tail.next = new ListNode(val);
            tail = tail.next;
        }

        return dummy.next;
    }
}
