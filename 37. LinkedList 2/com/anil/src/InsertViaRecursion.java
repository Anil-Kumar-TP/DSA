package com.anil.src;

public class InsertViaRecursion {

    private Node head;
    private int size;

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

    public void insert(int value,int index){
        head = insertRec(value,index,head);
    }

    private Node insertRec(int value,int index,Node node){
        if (index == 0){
            Node temp = new Node(value,node);
            size++;
            return temp;
        }
        node.next = insertRec(value,index - 1,node.next);
        return node;
    }
}


//1. The "Call" happens BEFORE the "Assignment"
//In any programming language, the right-hand side of an = must finish completely before the variable on the left is updated.
//
//Going Forward (Winding): When the CPU hits that line, it sees insertRec(...). It pauses the current method, saves all local variables to the Stack, and jumps to the new method call. The node.next = part is literally sitting in "limbo." It hasn't happened yet.
//
//Coming Back (Unwinding): Only when a function hits a return statement does the "limbo" end. The value being returned is brought back to the paused method, and finally, the node.next = assignment is executed.
//
//2. Trace it like a CPU: The Register View
//Let's look at what's happening at Index 1 (the node right before the insertion point).
//
//Phase 1: The Pause (Forward)
//
//We are at Node(20). index is 1.
//
//The CPU sees node.next = insertRec(99, 0, Node(30)).
//
//The Pause: The CPU "freezes" the Node(20) frame. It says: "I will update Node(20).next as soon as that function call tells me what the new address is."
//
//It jumps into the next call (index 0).
//
//Phase 2: The Return (Backward)
//
//The index 0 call finishes. It creates newNode(99) and returns its memory address (let's say 0x99).
//
//The Wake-up: The Node(20) frame wakes up. It receives 0x99.
//
//The Activation: Now, and only now, it executes: node.next = 0x99.
//
//The Chain: Node(20) is now successfully linked to the new node.