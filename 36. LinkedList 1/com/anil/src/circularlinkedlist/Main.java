package com.anil.src.circularlinkedlist;

public class Main {
    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();
        list.insert(21);
        list.insert(11);
        list.insert(41);
        list.insert(1);
        list.delete(1);
        list.display();
    }
}
