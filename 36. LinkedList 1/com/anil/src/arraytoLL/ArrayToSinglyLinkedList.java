package com.anil.src.arraytoLL;

public class ArrayToSinglyLinkedList {

    private Node head;
    private Node tail;

    private class Node{
        private int value;
        private Node next;

        public Node(int value){
            this.value = value;
        }

        public Node(int value,Node next){
            this.value = value;
            this.next = next;
        }
    }

    public void display(){
        Node temp = head;
        while (temp != null){
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    public void fromArray(int[] arr){
        if (arr.length == 0){
            return;
        }

        head = new Node(arr[0]);
        tail = head;

        for (int i = 1; i < arr.length; i++){
            Node node = new Node(arr[i]);
            tail.next = node;
            tail = node;
        }
    }

    public int getSize(){
        int count = 0;
        Node temp = head;
        while (temp != null){
            count++;
            temp = temp.next;
        }
        return count;
    }

    public int checkIfPresent(int value){
        Node temp = head;
        while (temp != null){
            if (temp.value == value){
                return 1;
            }
            temp = temp.next;
        }
        return 0;
    }
}

class Main{
    public static void main(String[] args) {
        int[] arr = {2,3,1,9,4};
        ArrayToSinglyLinkedList list = new ArrayToSinglyLinkedList();
        list.fromArray(arr);
        list.display();
        System.out.println(list.getSize());
        System.out.println(list.checkIfPresent(1));
    }
}
