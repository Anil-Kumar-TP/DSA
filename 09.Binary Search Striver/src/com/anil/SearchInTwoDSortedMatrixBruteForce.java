package src.com.anil;

public class SearchInTwoDSortedMatrixBruteForce {
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

    private static boolean search(int[][] arr, int n, int m,int target) {
        for (int row = 0; row < n; row++){
            for (int col = 0; col < m; col++){
                if (arr[row][col] == target){
                    return true;
                }
            }
        }
        return false;
    }
}
