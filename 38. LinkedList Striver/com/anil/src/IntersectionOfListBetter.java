package com.anil.src;

import java.util.List;

public class IntersectionOfListBetter {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA,ListNode headB) {
        int lengthA = getLength(headA);
        int lengthB = getLength(headB);

        ListNode temp1 = headA;
        ListNode temp2 = headB;

        int diff = Math.abs(lengthA - lengthB);

        if (lengthA > lengthB){
            for (int i = 0; i < diff; i++){
                temp1 = temp1.next;
            }
        }else {
            for (int i = 0; i < diff; i++){
                temp2 = temp2.next;
            }
        }

        while (temp1 != null && temp2 != null){
            if (temp1 == temp2){
                return temp1;
            }

            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        return null;
    }

    private int getLength(ListNode head) {
        int length = 0;
        while (head != null){
            length++;
            head = head.next;
        }

        return length;
    }
}
