package com.anil.src;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    public class Node{
        int key;
        int value;
        Node prev;
        Node next;


        Node(int key,int value){
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    private Map<Integer,Node> map;
    private Node head;
    private Node tail;

    public LRUCache(int capacity){
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(-1,-1);
        tail = new Node(-1,-1);

        head.next = tail;
        tail.prev = head;
    }


    public int get(int key){
        if (!map.containsKey(key)){
            return -1;
        }

        Node node = map.get(key);
        remove(node);
        insertAtFront(node);
        return node.value;
    }

    public void put(int key,int value){
        if (map.containsKey(key)){
            Node node = map.get(key);
            node.value = value;
            remove(node);
            insertAtFront(node);
        }else {
            if (map.size() == capacity) {
                Node node = tail.prev;
                remove(node);
                map.remove(node.key);
            }

            Node newNode = new Node(key,value);
            insertAtFront(newNode);
            map.put(key,newNode);
        }
    }

    private void insertAtFront(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}


//Why store the key inside the Node if the Map already knows the key?
//When the cache is full, you have to delete the oldest node (at the tail.prev). At that exact moment, you have the Node object in your hand, but you also need to delete that entry from the HashMap.
//
//Without the key stored inside the Node, the list wouldn't know which key to tell the Map to delete.