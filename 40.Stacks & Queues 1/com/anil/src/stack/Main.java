package com.anil.src.stack;

public class Main {
    public static void main(String[] args) throws StackException {
//        CustomStackFixedSize stack = new CustomStackFixedSize(5);
//        stack.push(13);
//        stack.push(32);
//        stack.push(3);
//        stack.push(93);
//        stack.push(10);
//
//        System.out.println(stack.peek());
//
//        System.out.println(stack.pop());


        DynamicStack stack1 = new DynamicStack(5);
        stack1.push(13);
        stack1.push(32);
        stack1.push(3);
        stack1.push(93);
        stack1.push(10);
        stack1.push(30);

        System.out.println(stack1.peek());

        System.out.println(stack1.size());
    }
}
