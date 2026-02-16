package com.anil.src;

public class RotateList2 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode rotateLeft(ListNode head, int k) {

        if (head == null || head.next == null || k == 0)
            return head;

        // 1️⃣ Find length and tail
        ListNode curr = head;
        int length = 1;

        while (curr.next != null) {
            curr = curr.next;
            length++;
        }

        // 2️⃣ Make circular
        curr.next = head;

        // 3️⃣ Reduce k
        k = k % length;

        // 4️⃣ Move to new tail (k steps)
        ListNode newTail = head;

        for (int i = 1; i < k; i++) {
            newTail = newTail.next;
        }

        // 5️⃣ Break
        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }

}

//
//🔹 What Does “Rotate Left by k” Mean?
//
//Example:
//
//        1 → 2 → 3 → 4 → 5
//k = 2
//
//
//Rotate left by 2:
//
//        3 → 4 → 5 → 1 → 2
//
//
//What happened?
//
//The first 2 nodes moved to the end.
//
//🔹 Compare With Rotate Right
//
//Rotate right by 2:
//
//        4 → 5 → 1 → 2 → 3
//
//
//Rotate left by 2:
//
//        3 → 4 → 5 → 1 → 2
//
//
//Notice something important:
//
//Rotating left by k
//is the same as
//Rotating right by (length - k)
//
//So we don’t need a new algorithm.
//
//🔹 Structural Thinking for Left Rotation
//
//Again use the cut-and-attach mental model.
//
//        Original:
//
//        1 → 2 → 3 → 4 → 5
//
//
//Rotate left by 2.
//
//Cut after 2 nodes:
//
//        1 → 2     3 → 4 → 5
//
//
//Now attach tail to head:
//
//        3 → 4 → 5 → 1 → 2
//
//
//That’s it.
//
//        🔹 Where Do We Cut?
//
//For left rotation:
//
//cutPosition = k
//
//
//For right rotation:
//
//cutPosition = length - k
//
//
//That’s the only difference.