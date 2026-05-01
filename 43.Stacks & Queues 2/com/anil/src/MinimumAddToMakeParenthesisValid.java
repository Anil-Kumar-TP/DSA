package com.anil.src;

import java.util.Stack;

public class MinimumAddToMakeParenthesisValid {
    public static void main(String[] args) {
        String str = "())";
        int ans = minimumAdd(str);
        System.out.println(ans);
    }

    private static int minimumAdd(String str) {
        Stack<Character> stack = new Stack<>();

        for (char ch : str.toCharArray()){
            if (ch == '('){
                stack.push(ch);
            }else {
                if (!stack.isEmpty() && stack.peek() == '('){
                    stack.pop();
                }else {
                    stack.push(ch);
                }
            }
        }

        return stack.size();
    }
}
