package com.anil.src;

public class StripAllAsBetter {
    public static void main(String[] args) {
        String str = "aabcba";
        StringBuilder stringBuilder = new StringBuilder();
        strip(str,0,stringBuilder);
        String ans = stringBuilder.toString();
        System.out.println(ans);
    }

    private static void strip(String str, int index, StringBuilder stringBuilder) {
        if (index == str.length()){
            return;
        }
        char ch = str.charAt(index);

        if (ch != 'a'){
            stringBuilder.append(ch);
        }

        // Note: No 'backtrack' is needed because we are not undoing a choice;
        // we are simply building a final product.

        strip(str,index + 1,stringBuilder);
    }
}
