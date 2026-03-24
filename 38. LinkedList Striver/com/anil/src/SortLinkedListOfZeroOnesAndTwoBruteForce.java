package com.anil.src;

public class SortLinkedListOfZeroOnesAndTwoBruteForce {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode sortList(ListNode head){
        if (head == null || head.next == null){
            return head;
        }

        int count0 = 0;
        int count1 = 0;
        int count2 = 0;

        ListNode temp = head;

        while (temp != null){
            if (temp.val == 0){
                count0++;
            }else if (temp.val == 1){
                count1++;
            }else {
                count2++;
            }
            temp = temp.next;
        }

        temp = head;

        while (temp != null){
            if (count0 > 0){
                temp.val = 0;
                count0--;
            }else if (count1 > 0){
                temp.val = 1;
                count1--;
            }else {
                temp.val = 2;
                count2--;
            }

            temp = temp.next;
        }

        return head;
    }
}
