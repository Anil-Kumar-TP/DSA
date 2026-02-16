package com.anil.src;

public class ReverseAlternateNodesInKGroup {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode reverseAlternate(ListNode head,int k){
        if (head == null || k <= 1){
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode groupPrev = dummy;
        boolean shouldReverse = true;

        while (true){
            ListNode kth = getKth(groupPrev,k);
            if (kth == null){
                break;
            }
            ListNode groupNext = kth.next;

            if (shouldReverse){
                ListNode prev = groupNext;
                ListNode curr = groupPrev.next;
                while (curr != groupNext) {
                    ListNode temp = curr.next;
                    curr.next = prev;
                    prev = curr;
                    curr = temp;
                }

                ListNode temp = groupPrev.next;
                groupPrev.next = kth;
                groupPrev = temp;
            }else {
                groupPrev = kth;
            }

            shouldReverse = !shouldReverse;
        }

        return dummy.next;
    }

    private ListNode getKth(ListNode curr, int k) {
        while (curr != null && k > 0){
            curr = curr.next;
            k--;
        }
        return curr;
    }
}
