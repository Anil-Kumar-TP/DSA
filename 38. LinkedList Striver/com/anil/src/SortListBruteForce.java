package com.anil.src;

import java.util.ArrayList;
import java.util.Collections;

public class SortListBruteForce {

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }

        ArrayList<Integer> list = new ArrayList<>();

        ListNode temp = head;
        while (temp != null) {
            list.add(temp.val);
            temp = temp.next;
        }

        Collections.sort(list);

        //instead of using convert array to list we override the values.
        //can also be done by converting to a list
        temp = head;
        for (int val : list){
            temp.val = val;
            temp = temp.next;
        }

        return head;
    }
}
