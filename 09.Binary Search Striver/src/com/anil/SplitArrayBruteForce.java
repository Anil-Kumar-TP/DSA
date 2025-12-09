package src.com.anil;

public class SplitArrayBruteForce {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40};
        int k = 2;
        int ans = split(arr,k);
        System.out.println(ans);
    }

    //no need for edge case like books
//    In “Split Array,” we can have fewer than k partitions (i.e., some subarrays can be merged).
   // But in “Book Allocation,” you can’t merge students or leave them without books.
    private static int split(int[] arr, int k) {
        int minSubArraySum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < arr.length; i++){
            minSubArraySum = Math.max(minSubArraySum,arr[i]);
            sum = sum + arr[i];
        }
        for (int subArraySum = minSubArraySum; subArraySum <= sum; subArraySum++){
            if (countPartitions(arr,subArraySum) <= k){
                return subArraySum;
            }
        }
        return minSubArraySum;
    }

    private static int countPartitions(int[] arr, int subArraySum) {
        int partitions = 1;
        int partitionSum = 0;
        for (int i = 0; i < arr.length; i++){
            if (arr[i] + partitionSum <= subArraySum){
                partitionSum = partitionSum + arr[i];
            }else {
                partitions = partitions + 1;
                partitionSum = arr[i];
            }
        }
        return partitions;
    }
}
