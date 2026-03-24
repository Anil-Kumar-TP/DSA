package com.anil.src;

public class BrowserHistory {

    class Node{
        String url;
        Node next;
        Node prev;

        Node(String url){
            this.url = url;
        }
    }

    private Node current;

    public BrowserHistory(String homePage){
        current = new Node(homePage);
    }


    public void visit(String url) {
        Node newNode = new Node(url);
        newNode.prev = current;
        current.next = newNode;
        current = newNode;
    }

    public String back(int steps) {
        while (steps > 0 && current.prev != null) {
            current = current.prev;
            steps--;
        }
        return current.url;
    }

    public String forward(int steps) {
        while (steps > 0 && current.next != null) {
            current = current.next;
            steps--;
        }
        return current.url;
    }
}
