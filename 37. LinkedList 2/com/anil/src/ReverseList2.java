package com.anil.src;

public class ReverseList2 {

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {

        if (head == null || left == right){
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        for (int i = 1; i < left; i++){
            prev = prev.next;
        }

        ListNode curr = prev.next;

        for (int i = 0; i < right - left; i++){
            ListNode next = curr.next;
            curr.next = next.next;
            next.next = prev.next;
            prev.next = next;
        }

        return dummy.next;
    }
}


//No — left is NOT 0-based here.
//left is 1-based, and that’s why the loop starts from 1, not 0.
//In LeetCode’s Reverse Linked List II:
//
//        1 ≤ left ≤ right ≤ length of list
//
//
//So:
//
//left is never 0
//
//The smallest possible value is 1



//If left were allowed to be 0:
//
//The idea of “node before position left” would break
//
//You’d be asking for “node before the head”



//If the problem statement says positions start from 1,
//your pointer-walking loop must start from 1 as well.


//
//How many rearrangements are needed?
//
//Suppose:
//
//left = 2
//right = 4
//
//
//Sublist:
//
//        2 → 3 → 4
//
//
//Number of nodes = right - left + 1 = 3
//
//To reverse this sublist in-place using the “front insertion” method:
//
//The first node (2) stays where it is
//
//The remaining nodes (3, 4) are moved to the front
//
//That is:
//
//number of moves = number of nodes - 1
//        = (right - left + 1) - 1
//        = right - left
//
//
//So we must do exactly right - left operations.
//
//Why start i from 0?
//
//Because:
//
//We want to do the operation exactly right - left times
//
//Starting from 0 and stopping at < right - left runs it that many time