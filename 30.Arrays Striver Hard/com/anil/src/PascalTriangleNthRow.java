package com.anil.src;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangleNthRow {
    public static void main(String[] args) {
        int n = 6;
        List<Long> ans = pascalRow(n);
        System.out.println(ans);
    }

    private static List<Long> pascalRow(int n) {
        List<Long> ans = new ArrayList<>();

        long result = 1;
        ans.add(result);

        for (int i = 1; i < n; i++){
            result = result * (n - i);
            result = result / i;

            ans.add(result);
        }

        return ans;
    }
}
