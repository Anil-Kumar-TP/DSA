package com.anil.src;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public static void main(String[] args) {
        String str = "aab";
        List<List<String>> ans = new ArrayList<>();
        palindromePartition(str,0,new ArrayList<>(),ans);
        System.out.println(ans);
    }

    private static void palindromePartition(String str, int index, ArrayList<String> path, List<List<String>> ans) {
        if (index == str.length()){
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < str.length(); i++){
            if (isPalindrome(str,index,i)){
                path.add(str.substring(index,i + 1));
                palindromePartition(str,i + 1,path,ans);
                path.remove(path.size() - 1);
            }
        }
    }

    private static boolean isPalindrome(String str, int start, int end) {
        while (start < end){
            if (str.charAt(start) != str.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
