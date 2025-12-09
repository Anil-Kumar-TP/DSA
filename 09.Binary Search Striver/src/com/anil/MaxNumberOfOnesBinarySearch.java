package src.com.anil;

public class MaxNumberOfOnesBinarySearch {
    public static void main(String[] args) {
        int[][] arr = {
                {1,1,1},
                {0,1,1},
                {0,0,1}
        };
        int n = 3;
        int m = 3;
        int ans = maxOnes(arr,n,m);
        System.out.println(ans);
    }

    private static int maxOnes(int[][] arr,int n,int m) {
        int index = -1;
        int maxCount = 0;
        for (int row = 0; row < n; row++){
            int firstOneIndex = findFirstOccurance(arr[row],m);
            int count = m - firstOneIndex;
            if (count > maxCount){
                maxCount = count;
                index = row;
            }
        }
        return index;
    }

    private static int findFirstOccurance(int[] row, int m) {
        int start = 0;
        int end = m - 1;
        int ans = -1;
        while (start <= end){
             int mid = start + (end - start) / 2;
             if (row[mid] == 1){
                 ans = mid;
                 end = mid - 1;
             }else {
                 start = mid + 1;
             }
        }
        return ans;
    }
}
