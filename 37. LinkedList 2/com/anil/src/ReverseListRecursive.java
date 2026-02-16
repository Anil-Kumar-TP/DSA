package com.anil.src;

public class ReverseListRecursive {

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode reverseList(ListNode head) {

        if (head == null || head.next == null){
            return head;
        }

        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}


//The Problem: Reverse a list starting at head.
//
//The Leap of Faith: Assume reverseList(head.next) already knows how to reverse the rest of the list perfectly.
//
//If you have 1 -> 2 -> 3 -> 4, and you are sitting at 1, assume the magic box gives you back 4 -> 3 -> 2. Your only job is to figure out how to attach 1 to the end of that.
//
//2. The Post-Order Strategy
//In linked lists, recursion usually happens on the way back up the stack (Post-Order).
//
//Go to the end first: Keep calling reverseList(head.next) until you hit the last node.
//
//The Return Value: The very last node (4 in our example) will be the newHead for the entire reversed list. We need to pass this value all the way back up the stack without changing it.
//
//The Work: Once the recursive call returns, you are standing at head, and you know that head.next is currently the tail of the already-reversed sub-list.
//
//3. The "Two-Node" Logic
//When writing the "work" part, ignore the 100 nodes in the list. Only look at two nodes: head and head.next.
//
//Current State: head -> next
//
//Goal: next -> head -> null





//Let's trace a simple list: [1] -> [2] -> [3] -> null.
//
//        1. The Expansion (Pushing onto the Stack)
//The CPU cannot finish reverseList(1) until reverseList(2) returns. It pushes frames onto the stack.
//
//Frame 1: head is 1. Calls reverseList(2). WAITING.
//
//        Frame 2: head is 2. Calls reverseList(3). WAITING.
//
//        Frame 3: head is 3. Hits base case (head.next == null). RETURNS 3.
//
//        2. The Unwinding (The Real Work)
//Now the stack pops. This is where the "magic" happens.
//
//Back in Frame 2 (head is 2):
//
//newHead is now 3 (passed back from Frame 3).
//
//The Line: head.next.next = head;
//
//head is 2. head.next is 3.
//
//So, 3.next = 2. (The pointer flips!)
//
//The Line: head.next = null;
//
//        2.next = null. (Breaking the old forward link).
//
//Return: 3.
//
//Back in Frame 1 (head is 1):
//
//newHead is still 3 (the tail of the original list is the new head).
//
//The Line: head.next.next = head;
//
//head is 1. head.next is 2.
//
//So, 2.next = 1.
//
//The Line: head.next = null;
//
//        1.next = null.
//
//Return: 3