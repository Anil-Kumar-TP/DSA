package com.anil.src.conversion;

import java.util.Stack;

public class InfixToPrefix {
    public static void main(String[] args) {
        String expression = "a+b*(c^d-e)";
        String ans = infixToPrefix(expression);
        System.out.println(ans);
    }

    private static String infixToPrefix(String expression) {

        StringBuilder reversed = new StringBuilder(expression).reverse();

        for (int i = 0; i < reversed.length(); i++){
            if (reversed.charAt(i) == '('){
                reversed.setCharAt(i,')');
            }else if (reversed.charAt(i) == ')'){
                reversed.setCharAt(i,'(');
            }
        }

        String postfix = infixToPostfix(reversed.toString());

        return new StringBuilder(postfix).reverse().toString();
    }

    private static String infixToPostfix(String expression) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (char ch : expression.toCharArray()){
            //operand.instead of multiple ifs.
            if (Character.isLetterOrDigit(ch)){
                result.append(ch);
            }

            else if (ch == '('){
                stack.push(ch);
            }

            else if (ch == ')'){
                while (!stack.isEmpty() && stack.peek() != '('){
                    result.append(stack.pop());
                }
                stack.pop();
            }

            else {
                while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(ch)){
                    result.append(stack.pop());
                }
                stack.push(ch);
            }

        }

        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.toString();
    }

    private static int precedence(char ch) {
        if (ch == '+' || ch == '-') return 1;
        if (ch == '*' || ch == '/') return 2;
        if (ch == '^') return 3;
        return -1;

    }
}
