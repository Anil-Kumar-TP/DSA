package src.com.anil;


public class SearchInTwoDSortedOptimal {
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
        int start = 0;
        int end = n * m - 1;
        while (start <= end){
            int mid = start + (end - start) / 2;
            int row = mid / m;
            int col = mid % m;
            if (arr[row][col] == target){
                return true;
            }else if (arr[row][col] < target){
                start = mid + 1;
            }else {
                end = mid - 1;
            }
        }
        return false;
    }
}
