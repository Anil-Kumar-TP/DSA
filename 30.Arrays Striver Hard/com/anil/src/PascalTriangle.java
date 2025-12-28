package com.anil.src;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public static void main(String[] args) {
        int n = 5;
        List<List<Integer>> ans = pascal(n);
        System.out.println(ans);
    }

    private static List<List<Integer>> pascal(int n) {
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 1; i <= n; i++){
            List<Integer> temp = generateRow(i);
            ans.add(temp);
        }//or just add ans.add(generateRow(i)).

        return ans;
    }

    private static List<Integer> generateRow(int row) {
        List<Integer> ans = new ArrayList<>();

        long result = 1;
        ans.add((int) result);

        for (int col = 1; col < row; col++){
            result = result * (row - col);
            result = result / col;

            ans.add((int) result);
        }

        return ans;
    }
}
