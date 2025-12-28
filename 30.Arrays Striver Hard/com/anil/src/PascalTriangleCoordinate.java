package com.anil.src;

public class PascalTriangleCoordinate {
    public static void main(String[] args) {
        int row = 5;
        int col = 3;
        long ans = pascalElement(row,col);
        System.out.println(ans);
    }

    private static long pascalElement(int row, int col) {
        int n = row - 1;
        int r = col - 1;

        long result = 1;

        for (int i = 0; i < r; i++){
            result = result * (n - i);
            result = result / (i + 1);
        }

        return result;
    }
}

//result = result * (n - i) / (i + 1);
//we can combine like this also