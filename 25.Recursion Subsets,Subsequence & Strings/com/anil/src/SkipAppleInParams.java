package com.anil.src;

public class SkipAppleInParams {
    public static void main(String[] args) {
        String str = "bccdapplejh";
        strip(str,"");
    }

    private static void strip(String initialOne, String finalOne) {
        if (initialOne.isEmpty()){
            System.out.println(finalOne);
            return;
        }
        if (initialOne.startsWith("apple")){
            strip(initialOne.substring(5),finalOne);
        }else {
            strip(initialOne.substring(1),finalOne + initialOne.charAt(0));
        }
    }
}
