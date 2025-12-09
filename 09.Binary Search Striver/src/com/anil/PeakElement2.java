package src.com.anil;

import java.util.Arrays;

public class PeakElement2 {
    public static void main(String[] args) {
        int[][] arr = {
                {4,2,5,1,4,5},
                {2,9,3,2,3,2},
                {1,7,6,0,1,3},
                {3,6,2,3,7,2}
        };
        int n = 4;
        int m = 6;
        int[] ans = peak(arr,n,m);
        System.out.println(Arrays.toString(ans));
    }

    private static int[] peak(int[][] arr, int n, int m) {
        int start = 0;
        int end = m - 1;
        while (start <= end){
            int mid = start + (end - start) / 2;
            int maxRowIndex = findMaxIndex(arr,n,m,mid);
            int left = mid - 1 >= 0 ? arr[maxRowIndex][mid - 1] : -1;
            int right = mid + 1 < m ? arr[maxRowIndex][mid + 1] : -1;
            if (arr[maxRowIndex][mid] > left && arr[maxRowIndex][mid] > right){
                return new int[]{maxRowIndex,mid};
            }
            else if (arr[maxRowIndex][mid] < left){
                end = mid - 1;
            }else {
                start = mid + 1;
            }
        }
        return new int[]{-1,-1};
    }

    private static int findMaxIndex(int[][] arr, int n, int m, int col) {
        int maxValue = Integer.MIN_VALUE;
        int index = -1;
        for (int i = 0; i < n; i++){
            if (arr[i][col] > maxValue){
                maxValue = arr[i][col];
                index = i;
            }
        }
        return index;
    }
}
