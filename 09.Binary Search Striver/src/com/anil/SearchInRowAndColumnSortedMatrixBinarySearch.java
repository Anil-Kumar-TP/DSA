package src.com.anil;

public class SearchInRowAndColumnSortedMatrixBinarySearch {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        int target = 17;
        int n = 5;
        int m = 5;
        boolean ans = search(arr,target,n,m);
        System.out.println(ans);
    }

    private static boolean search(int[][] arr, int target,int n,int m) {
        int row = 0;
        int col = m - 1;
        while (row < n && col >= 0){
            if (arr[row][col] == target){
                return true;
            }else if (arr[row][col] < target){
                row++;
            }else {
                col--;
            }
        }
        return false;
    }
}
