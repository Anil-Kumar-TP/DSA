package com.anil.src;

import java.util.Stack;

public class PalindromeListBruteForce {

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null){
            return true;
        }

        Stack<Integer> stack = new Stack<>();
        ListNode temp = head;

        while (temp != null){
            stack.push(temp.val);
            temp = temp.next;
        }

        temp = head;
        while (temp != null){
            if (temp.val != stack.pop()){
                return false;
            }
            temp = temp.next;
        }

        return true;
    }
}
