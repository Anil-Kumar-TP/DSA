package com.anil.src.conversion;

import java.util.Stack;

public class PostfixToInfix {
    public static void main(String[] args) {
        String expression = "ab+c*";
        String ans = postfixToInfix(expression);
        System.out.println(ans);
    }

    private static String postfixToInfix(String expression) {
        Stack<String> stack = new Stack<>();

        for (char ch : expression.toCharArray()){
            if (Character.isLetterOrDigit(ch)){
                stack.push(String.valueOf(ch));
            }else {
                String op2 = stack.pop();
                String op1 = stack.pop();

                String exp = "(" + op1 + ch + op2 + ")";
                stack.push(exp);
            }
        }
        return stack.pop();
    }
}
