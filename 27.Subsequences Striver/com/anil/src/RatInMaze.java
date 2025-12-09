package com.anil.src;

import java.util.ArrayList;
import java.util.List;

public class RatInMaze {
    public static void main(String[] args) {
        int[][] maze = {
                {1, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 1, 1, 1}
        };
        int n = maze.length;
        List<String> ans = new ArrayList<>();
        int[][] visited = new int[n][n];
        solve(0,0,n,maze,visited,"",ans);
        System.out.println(ans);
    }

    private static void solve(int row, int col, int n, int[][] maze, int[][] visited, String path, List<String> ans) {
        if (maze[0][0] == 0){
            return;
        }

        if (row == n - 1 && col == n - 1){
            ans.add(path);
            return;
        }

        visited[row][col] = 1;

        if (isSafe(row + 1,col,maze,n,visited)){
            solve(row + 1,col,n,maze,visited,path + "D",ans);
        }

        if (isSafe(row,col - 1,maze,n,visited)){
            solve(row,col - 1,n,maze,visited,path + "L",ans);
        }

        if (isSafe(row,col + 1,maze,n,visited)){
            solve(row,col + 1,n,maze,visited,path + "R",ans);
        }

        if (isSafe(row - 1,col,maze,n,visited)){
            solve(row - 1,col,n,maze,visited,path + "U",ans);
        }

        visited[row][col] = 0;
    }

    private static boolean isSafe(int row,int col,int[][] maze,int n,int[][] visited){
        return row >= 0 && col >= 0 && row < n && col < n && maze[row][col] == 1 && visited[row][col] == 0;
    }
}

