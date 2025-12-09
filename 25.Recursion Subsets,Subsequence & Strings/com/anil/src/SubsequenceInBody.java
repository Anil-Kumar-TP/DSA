package com.anil.src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SubsequenceInBody {
    public static void main(String[] args) {
        String str = "abc";
        List<String> ans = subsequence(str,"");
        Collections.sort(ans);
        System.out.println(ans);
    }

    private static List<String> subsequence(String initialOne, String finalOne) {
        List<String> list = new ArrayList<>();

        if (initialOne.isEmpty()){
            list.add(finalOne);
            return list;
        }

        char ch = initialOne.charAt(0);

        List<String> left = subsequence(initialOne.substring(1),finalOne + ch);
        List<String> right = subsequence(initialOne.substring(1),finalOne);

        left.addAll(right);
        return left;
    }
}
