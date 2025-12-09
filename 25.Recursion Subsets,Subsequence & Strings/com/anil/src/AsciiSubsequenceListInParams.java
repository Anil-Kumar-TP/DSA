package com.anil.src;

import java.util.ArrayList;

public class AsciiSubsequenceListInParams {
    public static void main(String[] args) {
        String str = "abc";
        ascii(str,"",new ArrayList<>());
    }

    private static void ascii(String initialOne, String finalOne, ArrayList<String> list) {
        if (initialOne.isEmpty()){
            System.out.println(finalOne);
            return;
        }
        char ch = initialOne.charAt(0);
        ascii(initialOne.substring(1),finalOne,list);
        ascii(initialOne.substring(1),finalOne + ch,list);
        ascii(initialOne.substring(1),finalOne + (ch + 0),list);
    }
}
