package com.anil.src;

import java.util.Arrays;

public class SudokuSolver {
    public static void main(String[] args) {
        char[][] board = {
                {'9', '5', '7', '.', '1', '3', '.', '8', '4'},
                {'4', '8', '3', '.', '5', '7', '1', '.', '6'},
                {'.', '1', '2', '.', '4', '9', '5', '3', '7'},
                {'1', '7', '.', '3', '.', '4', '9', '.', '2'},
                {'5', '.', '4', '9', '7', '.', '3', '6', '.'},
                {'3', '.', '9', '5', '.', '8', '7', '.', '1'},
                {'8', '4', '5', '7', '9', '.', '6', '1', '3'},
                {'.', '9', '1', '.', '3', '6', '.', '7', '5'},
                {'7', '.', '6', '1', '8', '5', '4', '.', '9'}
        };
        solve(board);
        System.out.println(Arrays.deepToString(board));
    }

    private static boolean solve(char[][] board) {
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                if (board[i][j] == '.'){
                    for (char ch = '1'; ch <= '9'; ch++){
                        if (isValid(board,i,j,ch)){
                            board[i][j] = ch;

                            if (solve(board)){
                                return true;//early exit
                            }else {
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
//
//    “Before I place ch at (row, col), I’m going to look at all 9 cells in the column and all 9 cells in the row (18 cells total, but some overlap), and if I see ch anywhere in them — I refuse.”
    private static boolean isValid(char[][] board, int row, int col, char ch) {
        for (int i = 0; i < 9; i++){ // i here is the index.
            if (board[i][col] == ch){
                return false;
            }

            if (board[row][i] == ch){
                return false;
            }

            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == ch){
                return false;
            }
        }
        return true;
    }
}
