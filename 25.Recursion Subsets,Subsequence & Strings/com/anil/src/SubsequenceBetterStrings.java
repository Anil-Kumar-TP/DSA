package com.anil.src;

import java.util.ArrayList;
import java.util.List;

//order matters for subsequences.so not allowed to sort unlike subsets.
public class SubsequenceBetterStrings {
    public static void main(String[] args) {
        String str = "abc";
        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>();
        subsequence(str, 0, sb, list);
        System.out.println(list);
    }

    private static void subsequence(String str, int index, StringBuilder path, List<String> list) {
        if (index == str.length()){
            list.add(path.toString());
            return;
        }
        // include
        path.append(str.charAt(index));
        subsequence(str,index + 1,path,list);
        path.deleteCharAt(path.length() - 1);

        //exclude
        subsequence(str,index + 1,path,list);
    }
}

//✔ If your “path” is a string builder → deleteCharAt()


//op should be like this bcs string concatenation has to take place here
//unlike where it is just characters in subsets.
//compare the op of both subsets & subsequence
