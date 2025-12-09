package com.anil.src;

public class Subsequence {
    public static void main(String[] args) {
        String str = "abc";
        subsequence(str,"");
    }

    private static void subsequence(String initialOne, String finalOne) {
        if (initialOne.isEmpty()){
            System.out.println(finalOne);
            return;
        }
        char ch = initialOne.charAt(0);
        subsequence(initialOne.substring(1),finalOne + ch);
        subsequence(initialOne.substring(1),finalOne);
    }
}
