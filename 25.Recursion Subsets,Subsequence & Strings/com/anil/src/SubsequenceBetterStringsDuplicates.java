package com.anil.src;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Convert the Set to a List ONLY AFTER recursion is complete
public class SubsequenceBetterStringsDuplicates {
    public static void main(String[] args) {
        String str = "aab";
        Set<String> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        subsequence(str,0,sb,set);//this was done so that final op will be a list
        List<String> ans = new ArrayList<>(set);//if we don't want, avoid this and just pass set in
        System.out.println(ans);//params and just print that set
    }

    private static void subsequence(String str, int index, StringBuilder path, Set<String> set) {
        if (index == str.length()){
            set.add(path.toString());
            return;
        }

        path.append(str.charAt(index));
        subsequence(str,index + 1,path,set);
        path.deleteCharAt(path.length() - 1);

        subsequence(str,index + 1,path,set);
    }
}

//Subsets = choose elements (order doesn’t matter) → path is a list of elements
//        Subsequence = build a single string (order matters) → path is a growing string
//
//        So subsets use:
//
//        path = List<Something>
//
//
//Subsequence uses:
//
//        path = StringBuilder



//❌ Wrong: “Why not use List for subsequence?”
//
//        Because subsequence is not a list.
//
//        ❌ Wrong: “Why not use StringBuilder for subsets?”
//
//        Because subsets are not strings.