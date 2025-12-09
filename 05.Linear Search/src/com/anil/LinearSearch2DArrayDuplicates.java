package src.com.anil;

import java.util.Arrays;

public class LinearSearch2DArrayDuplicates {
    public static void main(String[] args) {
        int[][] arr = {
                {2,3,4},
                {1,3,1,4,5},
                {4,6,7,9}
        };
        int target = 1;
        int[] ans = linearSearch(arr,target);
        System.out.println(Arrays.toString(ans));
    }

    private static int[] linearSearch(int[][] arr, int target) {
        if (arr.length == 0){
            return new int[]{-1,-1};
        }
        int[] lastIndex = new int[]{-1,-1};
        for (int row = 0; row < arr.length; row++){
            for (int col = 0; col < arr[row].length; col++){
                if (arr[row][col] == target){
                    lastIndex[0] = row;
                    lastIndex[1] = col;
                }
            }
        }
        return lastIndex;
    }
}
