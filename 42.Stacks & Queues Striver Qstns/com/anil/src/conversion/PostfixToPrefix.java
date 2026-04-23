package com.anil.src.conversion;

import java.util.Stack;

public class PostfixToPrefix {
    public static void main(String[] args) {
        String expression = "ab+c*";
        String ans = postfixToPrefix(expression);
        System.out.println(ans);
    }

    private static String postfixToPrefix(String expression) {
        Stack<String> stack = new Stack<>();

        for (char ch : expression.toCharArray()){
            if (Character.isLetterOrDigit(ch)){
                stack.push(String.valueOf(ch));
            }else {
                String op2 = stack.pop();
                String op1 = stack.pop();

                String exp = ch + op1 + op2;
                stack.push(exp);
            }
        }
        return stack.pop();
    }
}
