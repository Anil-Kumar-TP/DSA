package com.anil.src;

public class ReverseAlternateNodesInKGroup {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode reverseKGroup(ListNode head, int k) {

        if (head == null || k == 1) {
            return head;
        }

        ListNode curr = head;
        ListNode prevGroupTail = null;
        boolean shouldReverse = true;

        while (curr != null) {
            ListNode kthNode = getKthNode(curr,k);
            if (kthNode == null) {
                if (prevGroupTail != null) {
                    prevGroupTail.next = curr;
                }
                break;
            }

            ListNode nextGroupHead = kthNode.next;

            if (shouldReverse) {
                kthNode.next = null;
                ListNode newGroupHead = reverse(curr);
                if (prevGroupTail == null) {
                    head = newGroupHead;
                }else {
                    prevGroupTail.next = newGroupHead;
                }

                prevGroupTail = curr;
            }else {
                if (prevGroupTail != null) {
                    prevGroupTail.next = curr;
                }
                prevGroupTail = kthNode;
            }

            curr = nextGroupHead;
            shouldReverse = !shouldReverse;
        }
        return head;
    }

    private ListNode reverse(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode prev = null;
        ListNode curr = head;

        while (curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    private ListNode getKthNode(ListNode temp, int k) {
        while (temp != null && k > 1) {
            temp = temp.next;
            k--;
        }
        return temp;
    }
}
