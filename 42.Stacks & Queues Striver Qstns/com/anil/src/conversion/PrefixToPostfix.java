package com.anil.src.conversion;

import java.util.Stack;

public class PrefixToPostfix {
    public static void main(String[] args) {
        String expression = "*+abc";
        String ans = prefixToPostfix(expression);
        System.out.println(ans);
    }

    private static String prefixToPostfix(String expression) {
        Stack<String> stack = new Stack<>();

        for (int i = expression.length() - 1; i >= 0; i--){
            char ch = expression.charAt(i);

            if (Character.isLetterOrDigit(ch)){
                stack.push(String.valueOf(ch));
            }else {
                String op1 = stack.pop();
                String op2 = stack.pop();

                String exp = op1 + op2 + ch;
                stack.push(exp);
            }
        }

        return stack.pop();
    }
}
