package com.anil.src;

import java.util.ArrayList;
import java.util.List;

public class AsciiSubsequenceListInBody {
    public static void main(String[] args) {
        String str = "abc";
        List<String> ans = ascii(str,"");
        System.out.println(ans);
    }

    private static List<String> ascii(String initialOne, String finalOne) {
        List<String> list = new ArrayList<>();
        if (initialOne.isEmpty()){
            list.add(finalOne);
            return list;
        }

        char ch = initialOne.charAt(0);

        List<String> first = ascii(initialOne.substring(1),finalOne);
        List<String> second = ascii(initialOne.substring(1),finalOne + ch);
        List<String> third = ascii(initialOne.substring(1),finalOne + (ch + 0));

        list.addAll(first);
        list.addAll(second);
        list.addAll(third);

        return list;
    }
}
