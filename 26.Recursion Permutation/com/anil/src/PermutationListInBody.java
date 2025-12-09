package com.anil.src;

import java.util.ArrayList;
import java.util.List;

public class PermutationListInBody {
    public static void main(String[] args) {
        List<String> ans = permutation("","abc");
        System.out.println(ans);
    }

    private static List<String> permutation(String finalOne, String initialOne) {
        List<String> list = new ArrayList<>();

        if (initialOne.isEmpty()){
            list.add(finalOne);
            return list;
        }

        char ch = initialOne.charAt(0);
        for (int i = 0; i <= finalOne.length(); i++){
            String first = finalOne.substring(0,i);
            String second = finalOne.substring(i,finalOne.length());
            List<String> ans = permutation(first + ch + second,initialOne.substring(1));
            list.addAll(ans);
        }
        return list;
    }
}
