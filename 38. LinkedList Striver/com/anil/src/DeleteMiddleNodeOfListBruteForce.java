package com.anil.src;

public class DeleteMiddleNodeOfListBruteForce {

    public class ListNode {
     int val;
     ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null){
            return null;
        }

        int length = 0;
        ListNode temp = head;
        while (temp != null){
            length++;
            temp = temp.next;
        }

        int middle = length / 2;

        temp = head;
        for (int i = 0; i < middle - 1; i++){
            temp = temp.next;
        }

        temp.next = temp.next.next;

        return head;
    }
}
