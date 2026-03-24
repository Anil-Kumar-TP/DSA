package com.anil.src;

import java.util.ArrayList;

public class PairsWithGivenSumInDLLBruteForce {

    public class Node {
        int data;
        Node next,prev;

        Node(int x){
            data = x;
            next = null;
            prev = null;
        }
    }

    public ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target, Node head) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        Node temp1 = head;
        while (temp1 != null){
            Node temp2 = temp1.next;
            while (temp2 != null){
                if (temp1.data + temp2.data == target){
                    ArrayList<Integer> pair = new ArrayList<>();
                    pair.add(temp1.data);
                    pair.add(temp2.data);
                    result.add(pair);
                }
                temp2 = temp2.next;
            }
            temp1 = temp1.next;
        }

        return result;
    }
}
