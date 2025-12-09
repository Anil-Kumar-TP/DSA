package src.com.anil;

public class SplitArrayBinarySearch {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40};
        int k = 2;
        int ans = split(arr,k);
        System.out.println(ans);
    }

    private static int split(int[] arr, int k) {
        int minSubArraySum = Integer.MIN_VALUE;
        int sum = 0;
        int ans = -1;
        for (int i = 0; i < arr.length; i++){
            minSubArraySum = Math.max(minSubArraySum,arr[i]);
            sum = sum + arr[i];
        }
        int start = minSubArraySum;
        int end = sum;
        while (start <= end){
            int mid = start + (end - start) / 2;
            int partitions = countPartitions(arr,mid);
            if (partitions <= k){
                ans = mid;
                end = mid - 1;
            }else {
                start = mid + 1;
            }
        }
        return ans;
    }

    private static int countPartitions(int[] arr, int mid) {
        int partitions = 1;
        int partitionSum = 0;
        for (int i = 0; i < arr.length; i++){
            if (arr[i] + partitionSum <= mid){
                partitionSum = partitionSum + arr[i];
            }else {
                partitions = partitions + 1;
                partitionSum = arr[i];
            }
        }
        return partitions;
    }
}
