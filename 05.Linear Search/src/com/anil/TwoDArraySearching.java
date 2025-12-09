package src.com.anil;

import java.util.Arrays;

public class TwoDArraySearching {
    public static void main(String[] args) {
        int[][] arr = {
                {2,3,5},
                {6,8,9,1},
                {4,7}
        };
        int target = 1;
        int[] ans = linearSearch(arr,target);
        System.out.println(Arrays.toString(ans));
    }

    private static int[] linearSearch(int[][] arr, int target) {
        if (arr.length == 0){
            return new int[]{-1,-1};
        }
        for (int row = 0; row < arr.length; row++){
            for (int col = 0; col < arr[row].length; col++){
                if (arr[row][col] == target){
                    return new int[]{row,col};
                }
            }
        }
        return new int[]{-1,-1};
    }
}
