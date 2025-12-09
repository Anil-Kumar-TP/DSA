package src.com.anil;

public class MinimumCapacityToShipBinarySearch {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        int d = 5;
        int ans = ship(arr,d);
        System.out.println(ans);
    }

    private static int ship(int[] arr, int d) {
        int minCapacity = Integer.MAX_VALUE;
        int maxCapacity = 0;
        for (int i = 0; i < arr.length; i++){
            minCapacity = Math.min(minCapacity,arr[i]);
            maxCapacity = maxCapacity + arr[i];
        }
        int start = minCapacity;
        int end = maxCapacity;
        int ans = 0;
        while (start <= end){
            int mid = start + (end - start) / 2;
            int days = findDays(arr,mid);
            if (days <= d){
                ans = mid;
                end = mid - 1;
            }else {
                start = mid + 1;
            }
        }
        return ans;
    }

    private static int findDays(int[] arr, int capacity) {
        int days = 1;
        int load = 0;
        for (int i = 0; i < arr.length; i++){
            if (arr[i] + load > capacity){
                days = days + 1;
                load = arr[i];
            }else {
                load = load + arr[i];
            }
        }
        return days;
    }
}
