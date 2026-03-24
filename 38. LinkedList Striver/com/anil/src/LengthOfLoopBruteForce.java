package com.anil.src;


import java.util.HashMap;

public class LengthOfLoopBruteForce {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public int lengthOfLoop(ListNode head) {
        HashMap<ListNode, Integer> map = new HashMap<>();

        ListNode temp = head;
        int position = 0;

        while (temp != null){
            if (map.containsKey(temp)){
                int value = map.get(temp);
                return position - value;
            }

            map.put(temp,position);
            position++;
            temp = temp.next;
        }
        return 0;
    }
}
