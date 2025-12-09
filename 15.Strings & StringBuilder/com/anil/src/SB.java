package com.anil.src;

public class SB {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i <= 26; i++){
            char ch = (char) ('A' + i - 1);
            stringBuilder.append(ch);
        }
        System.out.println(stringBuilder); //both println and print same op
        //these are diff only when we use it inside the loop
        //otherwise outside the loop they are only printed once
        //so no difference.
    }
}
