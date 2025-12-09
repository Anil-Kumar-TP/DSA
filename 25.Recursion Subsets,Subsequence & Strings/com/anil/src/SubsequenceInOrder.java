package com.anil.src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SubsequenceInOrder {
    public static void main(String[] args) {
        String str = "abc";
        List<String> ans = new ArrayList<>();
        subsequence(str,"",ans);
        Collections.sort(ans);
        System.out.println(ans);
    }

    private static void subsequence(String initialOne, String finalOne, List<String> list) {
        if (initialOne.isEmpty()){
            list.add(finalOne);
            return;
        }
        char ch = initialOne.charAt(0);

        subsequence(initialOne.substring(1),finalOne + ch,list);
        subsequence(initialOne.substring(1),finalOne,list);
    }
}
