package com.anil.src;

public class SortLinkedListOfZeroOnesAndTwoOptimal {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode zeroDummy = new ListNode(-1);
        ListNode oneDummy = new ListNode(-1);
        ListNode twoDummy = new ListNode(-1);

        ListNode zero = zeroDummy;
        ListNode one = oneDummy;
        ListNode two = twoDummy;

        ListNode temp = head;

        while (temp != null){
            if (temp.val == 0){
                zero.next = temp;
                zero = zero.next;
            }else if (temp.val == 1){
                one.next = temp;
                one = one.next;
            }else {
                two.next = temp;
                two = two.next;
            }

            temp = temp.next;
        }

        zero.next = (oneDummy.next != null) ? oneDummy.next : twoDummy.next;
        one.next = twoDummy.next;
        two.next = null;

        return zeroDummy.next;
    }
}
