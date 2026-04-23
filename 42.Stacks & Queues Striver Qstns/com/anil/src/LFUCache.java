package com.anil.src;

import java.util.HashMap;
import java.util.Map;

public class LFUCache {

    public class Node{
        int key;
        int value;
        Node prev;
        Node next;
        int freq;

        Node(int key,int value){
            this.key = key;
            this.value = value;
            freq = 1;
        }
    }

    public class DLL{
        Node head;
        Node tail;
        int size;

        DLL(){
            head = new Node(-1,-1);
            tail = new Node(-1,-1);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        void addAtFront(Node node){
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
            size++;
        }

        void remove(Node node){
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }

        Node removeLast(){
            if (size > 0) {
                Node last = tail.prev;
                remove(last);
                return last;
            }
            return null;
        }
    }

    private int capacity;
    private int minFreq;
    private Map<Integer,Node> keyMap;
    private Map<Integer,DLL> freqMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        keyMap = new HashMap<>();
        freqMap = new HashMap<>();
        minFreq = 0;
    }

    public int get(int key) {
        if (!keyMap.containsKey(key)) return -1;

        Node node = keyMap.get(key);
        update(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) return;

        if (keyMap.containsKey(key)) {
            Node node = keyMap.get(key);
            node.value = value;
            update(node);
        } else {

            if (keyMap.size() == capacity) {
                DLL minList = freqMap.get(minFreq);
                Node toRemove = minList.removeLast();
                keyMap.remove(toRemove.key);
            }

            Node newNode = new Node(key, value);
            keyMap.put(key, newNode);

            freqMap.putIfAbsent(1, new DLL());
            freqMap.get(1).addAtFront(newNode);

            minFreq = 1;
        }
    }

    private void update(Node node) {
        int freq = node.freq;
        DLL list = freqMap.get(freq);

        list.remove(node);

        if (freq == minFreq && list.size == 0) {
            minFreq++;
        }

        node.freq++;

        freqMap.putIfAbsent(node.freq, new DLL());
        freqMap.get(node.freq).addAtFront(node);
    }
}
