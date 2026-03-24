package com.anil.src;

public class RemoveNthNodeFromEndBruteForce {

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null){
            return null;
        }

        int count = 0;
        ListNode temp = head;

        while (temp != null){
            count++;
            temp = temp.next;
        }

        if (count == n){
            return head.next;
        }

        int res = count - n;

        temp = head;
        while (temp != null){
            res--;
            if (res == 0){
                break;
            }
            temp = temp.next;
        }

        temp.next = temp.next.next;

        return head;
    }
}


//  for (int i = 1; i < res; i++) {
//temp = temp.next;
//    }instead of while and break use this