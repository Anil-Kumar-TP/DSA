package com.anil.src;

public class SkipAppleInBody {
    public static void main(String[] args) {
        String str = "bccdapplejh";
        String ans = strip(str);
        System.out.println(ans);
    }

    private static String strip(String initialOne) {
        if (initialOne.isEmpty()){
            return "";
        }

        if (initialOne.startsWith("apple")){
            return strip(initialOne.substring(5));
        }else {
            return initialOne.charAt(0) + strip(initialOne.substring(1));
        }
    }
}
