package src.com.anil;

import java.util.Arrays;

public class AggressiveCowsBruteForce {
    public static void main(String[] args) {
        int[] arr = {0, 3, 4, 7, 10, 9};
        int k = 4;
        int ans = cows(arr,k);
        System.out.println(ans);
    }

    private static int cows(int[] arr, int k) {
        Arrays.sort(arr);
        int maxValue = arr[arr.length - 1] - arr[0];
        for (int distance = 1; distance <= maxValue; distance++){
            if (!canWePlace(arr, distance, k)){
                return distance - 1;
            }
        }
        return maxValue;
    }

    private static boolean canWePlace(int[] arr, int distance, int k) {
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
