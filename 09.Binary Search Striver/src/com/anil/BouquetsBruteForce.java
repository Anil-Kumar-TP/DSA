package src.com.anil;

public class BouquetsBruteForce {
    public static void main(String[] args) {
        int[] arr = {7, 7, 7, 7, 13, 11, 12, 7};
        int k = 3;
        int m = 2;
        int ans = bouquets(arr,k,m);
        System.out.println(ans);
    }

    private static int bouquets(int[] arr, int k, int m) {
        int minDay = Integer.MAX_VALUE;
        int maxDay = Integer.MIN_VALUE;
        if (m * k > arr.length){
            return -1;
        }
        for (int num : arr){
            minDay = Math.min(minDay,num);
            maxDay = Math.max(maxDay,num);
        }
        for (int day = minDay; day <= maxDay; day++){
            if (possible(arr,day,k,m)){
                return day;
            }
        }
        return -1;
    }

    private static boolean possible(int[] arr, int day, int k, int m) {
        int count = 0;
        int numberOfBouquets = 0;
        for (int i = 0; i < arr.length; i++){
            if (arr[i] <= day){
                count++;
            }else {
                numberOfBouquets = numberOfBouquets + (count / k);
                count = 0;
            }
        }
        numberOfBouquets = numberOfBouquets + (count / k);
        return numberOfBouquets >= m;
    }
}
