package com.anil.src;

public class AsciiSubsequence {
    public static void main(String[] args) {
        String str = "abc";
        ascii(str,"");
    }

    private static void ascii(String initialOne, String finalOne) {
        if (initialOne.isEmpty()){
            System.out.println(finalOne);
            return;
        }
        char ch = initialOne.charAt(0);
        ascii(initialOne.substring(1),finalOne + ch);
        ascii(initialOne.substring(1),finalOne );
        ascii(initialOne.substring(1),finalOne + (ch + 0) );
    }
}
