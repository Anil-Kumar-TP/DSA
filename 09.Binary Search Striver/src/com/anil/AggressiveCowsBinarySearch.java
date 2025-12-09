package src.com.anil;

import java.util.Arrays;

public class AggressiveCowsBinarySearch {
    public static void main(String[] args) {
        int[] arr = {0, 3, 4, 7, 10, 9};
        int k = 4;
        int ans = cows(arr,k);
        System.out.println(ans);
    }

    private static int cows(int[] arr, int k) {
        Arrays.sort(arr);
        int start = 1;
        int end = arr[arr.length - 1] - arr[0];
        int ans = 0;
        while (start <= end){
            int mid = start + (end - start) / 2;
            if (canPlace(arr,mid,k)){
                ans = mid;
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return ans;
    }

    private static boolean canPlace(int[] arr, int distance, int k) {
        int placedCows = 1;
        int stall = arr[0];
        for (int i = 1; i < arr.length; i++){
            if (arr[i] - stall >= distance){
                placedCows = placedCows + 1;
                stall = arr[i];
            }
            if (placedCows >= k){
                return true;
            }
        }
        return false;
    }
}
