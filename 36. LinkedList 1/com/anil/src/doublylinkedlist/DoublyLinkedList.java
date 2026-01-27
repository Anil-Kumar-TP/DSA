package com.anil.src.doublylinkedlist;

public class DoublyLinkedList {

    private Node head;
    private int size;

    public DoublyLinkedList(){
        this.size = 0;
    }

    private class Node{
        private int value;
        private Node next;
        private Node prev;

        public Node(int value){
            this.value = value;
        }

        public Node(int value,Node next,Node prev){
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }

    public void display(){
        Node temp = head;
        Node last = null;
        System.out.println("FORWARD");
        while (temp != null){
            System.out.print(temp.value + " -> ");
             last = temp;
             temp = temp.next;
        }
        System.out.println("END");

        System.out.println("BACKWARD");
        while (last != null){
            System.out.print(last.value + " -> ");
            last = last.prev;
        }
        System.out.println("START");
    }

    public void insertAtFirst(int value){
        Node node = new Node(value);
        node.next = head;
        node.prev = null;
        if (head != null){
            head.prev = node;
        }
        head = node;
        size++;
    }

    public void insertAtLast(int value){
        Node node = new Node(value);
        Node temp = head;
        node.next = null;
        if (head == null){
            node.prev = null;
            head = node;
            return;
        }
        while (temp.next != null){
            temp = temp.next;
        }
        temp.next = node;
        node.prev = temp;
        size++;
    }

    public void insertAtIndex(int value, int index) {

        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            insertAtFirst(value);
            return;
        }

        if (index == size) {
            insertAtLast(value);
            size++;
            return;
        }

        Node temp = head;

        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }

        Node node = new Node(value);

        node.next = temp.next;
        node.prev = temp;

        temp.next.prev = node;
        temp.next = node;

        size++;
    }

    public void insertAfter(int target,int value){
        Node curr = find(target);
        if (curr == null){
            System.out.println("target do not exist");
            return;
        }
        Node node = new Node(value);

        node.next = curr.next;
        node.prev = curr;

        if (curr.next != null) {
            curr.next.prev = node;
        }

        curr.next = node;
        size++;
    }

    public int deleteFromFirst(){
        if (head == null){
            throw new RuntimeException("Empty list");
        }

        int value = head.value;

        if (head.next == null){
            head = null;
        }else {
            head = head.next;
            head.prev = null;
        }
        size--;
        return value;
    }

    public int deleteFromLast(){
        if (head == null){
            throw new RuntimeException("Empty list");
        }
        int value;

        if (head.next == null){
            value = head.value;
            head = null;
            size--;
            return value;
        }

        Node temp = head;
        while (temp.next != null){
            temp = temp.next;
        }

        value = temp.value;
        temp.prev.next = null;
        size--;
        return value;
    }

    public int deleteFromAnIndex(int index){
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        if (index == 0){
            return deleteFromFirst();
        }
        if (index == size - 1){
            return deleteFromLast();
        }
        Node temp = head;
        for (int i = 1; i < index; i++){
            temp = temp.next;
        }
        int value = temp.value;
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;

        return value;
    }

    public int deleteValue(int value){
        Node node = find(value);
        return deleteNode(node);
    }

    private int deleteNode(Node node) {
        int value = node.value;
        if (node.prev == null) {
            head = node.next;
            if (head != null) {
                head.prev = null;
            }
        }
        else if (node.next == null) {
            node.prev.next = null;
        }
        else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        size--;
        return value;
    }

    private Node find(int target) {
        Node temp = head;
        while (temp != null){
            if (temp.value == target){
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }
}
