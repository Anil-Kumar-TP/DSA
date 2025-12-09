package src.com.anil;

public class BouquetsBinarySearch {
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
        for (int num : arr){
            minDay = Math.min(minDay,num);
            maxDay = Math.max(maxDay,num);
        }
        if (m * k > arr.length){
            return -1;
        }
        int start = minDay;
        int end = maxDay;
        int ans = 0;
        while (start <= end){
            int mid = start + (end - start) / 2;
            if (possible(arr,mid,m,k)){
                ans = mid;
                end = mid - 1;
            }else {
                start = mid + 1;
            }
        }
        return ans;
    }

    private static boolean possible(int[] arr, int mid, int m, int k) {
        int count = 0;
        int numberOfBouquets = 0;
        for (int i = 0; i < arr.length; i++){
            if (arr[i] <= mid){
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
