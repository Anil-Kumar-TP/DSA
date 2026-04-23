package com.anil.src;

import java.util.Stack;

//MaxStack is similar,just flip the condition
//encoded = 2*val - max   (when val > max)
public class MinStackOptimal {

    Stack<Long> stack = new Stack<>();
    long minimum;

    public void push(int val){
        if (stack.isEmpty()) {
            stack.push((long) val);
            minimum = val;
        } else if (val >= minimum) {
            stack.push((long) val);
        }else {
            stack.push(2L * val - minimum);
            minimum = val;
        }
    }

    public void pop(){
        long top = stack.pop();
        if (top < minimum) {
            minimum = 2 * minimum - top;
        }
    }

    public int top(){
        long top = stack.peek();
        if (top < minimum) {
            return (int) minimum;
        }
        return (int) top;
    }

    public int getMin(){
        return (int) minimum;
    }
}
