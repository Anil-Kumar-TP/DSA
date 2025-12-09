package com.anil.src;

public class StripAllAsInParams {
    public static void main(String[] args) {
        String str = "abbaabd";
        strip(str,"");
    }

    private static void strip(String initialOne, String finalOne) {
        if (initialOne.isEmpty()){
            System.out.println(finalOne);
            return;
        }
        char ch = initialOne.charAt(0);

        if (ch == 'a'){
            strip(initialOne.substring(1),finalOne);
        }else {
            strip(initialOne.substring(1),finalOne + ch);
        }
    }
}
