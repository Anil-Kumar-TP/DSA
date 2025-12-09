package src.com.anil;

import java.util.Arrays;

public class SortedMatrix {
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

    private static int[] binarySearch(int[][] arr,int row,int cStart,int cEnd,int target){
        while (cStart <= cEnd){
            int mid = cStart + (cEnd - cStart) / 2;
            if (arr[row][mid] == target){
                return new int[]{row,mid};
            }
            if (arr[row][mid] < target){
                cStart = mid + 1;
            }else {
                cEnd = mid - 1;
            }
        }
        return new int[]{-1,-1};
    }

    private static int[] searchMatrix(int[][] arr, int target) {

        if (arr == null || arr.length == 0 || arr[0].length == 0){
            return new int[]{-1,-1};
        }

        int rows = arr.length;
        int cols = arr[0].length;

        if (rows == 1){
            return binarySearch(arr,0,0,cols - 1,target);
        }

        int rStart = 0;
        int rEnd = rows - 1;
        int cMid = cols / 2;

        while (rStart < (rEnd - 1)){
            int mid = rStart + (rEnd - rStart) / 2;
            if (arr[mid][cMid] == target){
                return new int[]{mid,cMid};
            }
            if (arr[mid][cMid] < target){
                rStart = mid;
            }else {
                rEnd = mid;
            }
        }

        //now we have two rows
        //check whether the target is in the col of 2 rows
        if (arr[rStart][cMid] == target){
            return new int[]{rStart,cMid};
        }

        if (arr[rStart + 1][cMid] == target){
            return new int[]{rStart + 1,cMid};
        }

        //search in first half
        if (target <= arr[rStart][cMid - 1]){
            return binarySearch(arr,rStart,0,cMid - 1,target);
        }

        if (target >= arr[rStart][cMid + 1] && target <= arr[rStart][cols - 1]){
            return binarySearch(arr,rStart,cMid + 1,cols - 1,target);
        }

        if (target <= arr[rStart + 1][cMid - 1]){
            return binarySearch(arr,rStart + 1,0,cMid - 1,target);
        }else {
            return binarySearch(arr,rStart + 1,cMid + 1,cols - 1,target);
        }
    }
}
