package com.anil.src.linkedlist;

public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insertAtFirst(12);
        list.insertAtFirst(90);
        list.insertAtFirst(19);
        list.insertAtFirst(32);
        list.insertAtLast(100);
        list.insertAtLast(70);
        list.insertAtIndex(201,3);
        System.out.println(list.deleteFromFirst());
        System.out.println(list.deleteFromLast());
        System.out.println(list.deleteFromAnIndex(4));
        list.display();
    }
}
