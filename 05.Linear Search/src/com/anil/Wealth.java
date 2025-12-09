package src.com.anil;

public class Wealth {
    public static void main(String[] args) {
        int[][] arr = {
                {1,2,4},
                {3,8,9},
                {14,17,5}
        };
        int ans = wealth(arr);
        System.out.println(ans);
    }

    private static int wealth(int[][] arr) {
        int maxWealth = Integer.MIN_VALUE;
        for (int customer = 0; customer < arr.length; customer++){
            int customerWealth = 0;
            for (int account = 0; account < arr[customer].length; account++){
               customerWealth = customerWealth + arr[customer][account];
            }
            if (customerWealth > maxWealth){
                maxWealth = customerWealth;
            }
        }
        return maxWealth;
    }
}
