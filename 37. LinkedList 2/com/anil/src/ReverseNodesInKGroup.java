package com.anil.src;

public class ReverseNodesInKGroup {

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1){
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode groupPrev = dummy;

        while (true){
            ListNode kth = getKth(groupPrev,k);
            if (kth == null){
                break;
            }

            ListNode groupNext = kth.next;
            ListNode prev = groupNext;
            ListNode curr = groupPrev.next;

            while (curr != groupNext){
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }

            ListNode temp = groupPrev.next;
            groupPrev.next = kth;
            groupPrev = temp;
        }

        return dummy.next;
    }

    private ListNode getKth(ListNode curr, int k) {
        while (curr != null && k > 0) {
            curr = curr.next;
            k--;
        }
        return curr;
    }
}



//High-Level Plan
//
//For each group:
//
//Check if k nodes exist
//
//Reverse exactly k nodes
//
//Connect:
//
//Previous group → new head of reversed group
//
//Tail of reversed group → next group
//
//Repeat.
//
//
//
//
//
//while (there are k nodes):
//find kth
//reverse from groupPrev.next to kth
//move groupPrev to end of reversed group