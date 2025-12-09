package src.com.anil;

import java.util.Arrays;

public class Flatten2DArrayAndBinarySearch {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };
        int target = 16;

        int[] ans = searchMatrix(arr, target);
        System.out.println(Arrays.toString(ans));
    }

    //here rows and cols are not pointers like prev qstn
    //just the number of rows and cols
    //that's why cols is not taken as arr[0].length - 1
    //and after flattening it would turn to 1 array,so now start and end are pointers
    private static int[] searchMatrix(int[][] arr, int target) {
        if (arr == null || arr.length == 0 || arr[0].length == 0){
            return new int[]{-1,-1};
        }
        int rows = arr.length;
        int cols = arr[0].length;
        int start = 0;
        int end = rows * cols - 1;
        while (start <= end){
            int mid = start + (end - start) / 2;
            int row = mid / cols;
            int col = mid % cols;

            if (arr[row][col] == target){
                return new int[]{row,col};
            }else if(arr[row][col] < target){
                start = mid + 1;
            }else {
                end = mid - 1;
            }
        }
        return new int[]{-1,-1};
    }
}
