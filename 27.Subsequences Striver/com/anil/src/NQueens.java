package com.anil.src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//solve(col):
//        if col == N: success
//        for r in 0..N-1:
//        if safe(r, col):
//        place(r,col)
//        solve(col+1)
//        remove(r,col)


public class NQueens {
    public static void main(String[] args) {
        int n = 4;
        char[][] board = new char[n][n];
        List<List<String>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++){
            Arrays.fill(board[i],'.');
        }
        solve(0,board,ans,n);
        System.out.println(ans);
    }

    private static void solve(int col, char[][] board, List<List<String>> ans, int n) {
        if (col == n){
            ans.add(build(board));
            return;
        }

        // try all rows in this column
        for (int row = 0; row < n; row++){
            if (isSafe(row,col,board,n)){
                board[row][col] = 'Q';
                solve(col + 1,board,ans,n);
                board[row][col] = '.';
            }
        }
    }

//    Since you are placing queens column-by-column, you only need to check the rows, columns, and diagonals that have already been filled, which simplifies the checks significantly.
    private static boolean isSafe(int row, int col, char[][] board, int n) {

        // check this row on all previous columns
        for (int j = 0; j < col; j++){
            if (board[row][j] == 'Q'){
                return false;
            }
        }

        // upper-left diagonal
        //both col and row decrease
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // lower-left diagonal
        //row increase col decrease
        for (int i = row, j = col; i < n && j >= 0; i++, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;

    }

    //this is needed bcs our board is char and we need to return List of List of String
    //so incompatible.needs conversion
    //even if the return type was List of List of character we would still need build
    //but different logic,bcs the same board is getting mutated.
    //refer permutationsOther,same concept of snapshot there also.
    private static List<String> build(char[][] board) {
        List<String> current = new ArrayList<>();
        for (char[] row : board){
            current.add(new String(row));
        }
        return current;
    }
}


//    // Target: List<List<Character>>
//    private static List<List<Character>> buildCharList(char[][] board) {
//        List<List<Character>> currentSolution = new ArrayList<>();
//
//        // Iterating through each char[] row
//        for (char[] row : board) {
//            // Must create a new List for this row
//            List<Character> charRow = new ArrayList<>();
//
//            // Convert char primitive array to List<Character> wrapper objects
//            for (char c : row) {
//                charRow.add(c); // Java auto-boxes 'c' (primitive) to Character (object)
//            }
//
//            // Add the new, independent list to the solution
//            currentSolution.add(charRow);
//        }
//        return currentSolution;
//    }