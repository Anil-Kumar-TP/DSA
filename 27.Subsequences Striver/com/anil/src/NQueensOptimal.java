package com.anil.src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueensOptimal {
    public static void main(String[] args) {
        int n = 4;
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++){
            Arrays.fill(board[i],'.');
        }
        List<List<String>> ans = new ArrayList<>();
        boolean[] rowUsed = new boolean[n];
        boolean[] lowerDiagonal = new boolean[2 * n - 1];
        boolean[] upperDiagonal = new boolean[2 * n - 1];
        solve(0,board,rowUsed,lowerDiagonal,upperDiagonal,ans,n);
        System.out.println(ans);
    }

    private static void solve(int col, char[][] board, boolean[] rowUsed, boolean[] lowerDiagonal, boolean[] upperDiagonal, List<List<String>> ans,int n) {
        if (col == n){
            ans.add(build(board));
            return;
        }

        for (int row = 0; row < n; row++){
            int lowerDiagonalIndex = row + col;
            int upperDiagonalIndex = (n - 1) + (col - row);

            if (!rowUsed[row] && !lowerDiagonal[lowerDiagonalIndex] && !upperDiagonal[upperDiagonalIndex]){
                board[row][col] = 'Q';
                rowUsed[row] = true;
                lowerDiagonal[lowerDiagonalIndex] = true;
                upperDiagonal[upperDiagonalIndex] = true;

                solve(col + 1,board,rowUsed,lowerDiagonal,upperDiagonal,ans,n);

                board[row][col] = '.';
                rowUsed[row] = false;
                lowerDiagonal[lowerDiagonalIndex] = false;
                upperDiagonal[upperDiagonalIndex] = false;
            }
        }
    }

    private static List<String> build(char[][] board) {
        List<String> current = new ArrayList<>();
        for (char[] row : board){
            current.add(new String(row));
        }
        return current;
    }
}
