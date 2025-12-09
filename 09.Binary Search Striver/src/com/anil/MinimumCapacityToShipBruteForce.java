package src.com.anil;

public class MinimumCapacityToShipBruteForce {
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
        for (int capacity = minCapacity; capacity <= maxCapacity; capacity++){
            int daysRequired = findDays(arr,capacity);
            if (daysRequired <= d){
                return capacity;
            }
        }
        return -1;
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
