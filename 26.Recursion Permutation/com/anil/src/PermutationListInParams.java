package com.anil.src;

import java.util.ArrayList;

public class PermutationListInParams {
    public static void main(String[] args) {
        ArrayList<String> ans = new ArrayList<>();
        permutation("","abc",ans);
        System.out.println(ans);
    }

    private static void permutation(String finalOne, String initialOne, ArrayList<String> list) {
        if (initialOne.isEmpty()){
            list.add(finalOne);
            return;
        }

        char ch = initialOne.charAt(0);
        for (int i = 0; i <= finalOne.length(); i++){
            String first = finalOne.substring(0,i);
            String second = finalOne.substring(i,finalOne.length());
            permutation(first + ch + second,initialOne.substring(1),list);
        }
    }
}
