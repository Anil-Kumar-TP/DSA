package src.com.anil;

public class MaxNumberOfOnesBruteForce {
    public static void main(String[] args) {
        int[][] arr = {
                {1,1,1},
                {0,1,1},
                {0,0,1}
        };
        int ans = maxOnes(arr);
        System.out.println(ans);
    }

    private static int maxOnes(int[][] arr) {
        int count_max = 0;
        int index = -1;
        for (int row = 0; row < arr.length; row++){
            int count = 0;
            for (int col = 0; col < arr[row].length; col++){
                if (arr[row][col] == 1){
                    count++;
                }
            }
            if (count > count_max){
                count_max = count;
                index = row;
            }
        }
        return index;
    }
}
