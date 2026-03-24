package com.anil.src;

import java.util.ArrayList;

public class PairsWithGivenSumInDLLOptimal {

    public class Node {
        int data;
        Node next,prev;

        Node(int x){
            data = x;
            next = null;
            prev = null;
        }
    }

    public ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target,Node head) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        if (head == null){
            return result;
        }

        Node left = head;
        Node right = head;
        while (right.next != null){
            right = right.next;
        }

        while (left != right && left.prev != right){
            int sum = left.data + right.data;

            if (sum == target){
                ArrayList<Integer> pair = new ArrayList<>();
                pair.add(left.data);
                pair.add(right.data);
                result.add(pair);
                left = left.next;
                right = right.prev;
            }else if (sum < target){
                left = left.next;
            }else {
                right = right.prev;
            }
        }

        return result;
    }
}
