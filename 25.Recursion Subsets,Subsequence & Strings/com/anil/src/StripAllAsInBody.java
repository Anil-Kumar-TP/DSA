package com.anil.src;

public class StripAllAsInBody {
    public static void main(String[] args) {
        String str = "abbcdba";
        String ans = strip(str);
        System.out.println(ans);
    }

    private static String strip(String initialOne) {
        if (initialOne.isEmpty()){
            return "";
        }
        char ch = initialOne.charAt(0);

        if (ch == 'a'){
            return strip(initialOne.substring(1));
        }else {
            return ch + strip(initialOne.substring(1));
        }
    }
}
