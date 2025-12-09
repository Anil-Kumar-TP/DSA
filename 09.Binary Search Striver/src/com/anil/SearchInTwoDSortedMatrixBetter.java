package src.com.anil;

public class SearchInTwoDSortedMatrixBetter {
    public static void main(String[] args) {
        int[][] arr = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12}
        };
        int n = 3;
        int m = 4;
        int target = 9;
        boolean ans = search(arr,n,m,target);
        System.out.println(ans);
    }

    private static boolean search(int[][] arr, int n, int m, int target) {
        for (int row = 0; row < n; row++){
            if (arr[row][0] <= target && target <= arr[row][m - 1]){
                return binarySearch(arr[row],target);
            }
        }
        return false;
    }

    private static boolean binarySearch(int[] row, int target) {
        int start = 0;
        int end = row.length - 1;
        while (start <= end){
            int mid = start + (end - start) / 2;
            if (row[mid] == target){
                return true;
            }else if (target < row[mid]){
                end = mid - 1;
            }else {
                start = mid + 1;
            }
        }
        return false;
    }
}
