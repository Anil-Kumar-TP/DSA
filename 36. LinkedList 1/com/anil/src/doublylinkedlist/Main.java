package com.anil.src.doublylinkedlist;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.insertAtFirst(12);
        list.insertAtFirst(21);
        list.insertAtFirst(33);
        list.insertAtLast(99);
        list.insertAfter(12,43);
        System.out.println(list.deleteFromFirst());
        System.out.println(list.deleteFromLast());
        System.out.println(list.deleteValue(21));
        list.display();
    }
}
