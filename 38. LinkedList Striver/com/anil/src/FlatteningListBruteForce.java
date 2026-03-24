package com.anil.src;

import java.util.ArrayList;
import java.util.Collections;

public class FlatteningListBruteForce {

    public class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    };

    public Node flatten(Node head) {
        if (head == null) {
            return null;
        }

        ArrayList<Integer> list = new ArrayList<>();

        Node temp = head;
        while (temp != null) {
            Node curr = temp;
            while (curr != null) {
                list.add(curr.val);
                curr = curr.child;
            }
            temp = temp.next;
        }

        Collections.sort(list);

        //build the list vertically
        Node dummy = new Node();
        Node tail = dummy;

        for (int val : list){
            Node newNode = new Node();
            newNode.val = val;
            tail.child = newNode;
            tail = tail.child;
        }
        return dummy.child;
    }
}
