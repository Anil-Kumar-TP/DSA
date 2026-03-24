package com.anil.src;

import java.util.HashSet;
import java.util.List;

public class DetectCycleInListBruteForce {

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
    }

    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> visited = new HashSet<>();

        ListNode temp = head;
        while (temp != null){
            if (visited.contains(temp)){
                return true;
            }

            visited.add(temp);
            temp = temp.next;
        }

        return false;
    }
}
