package src.com.anil;

public class SmallestDivisorBinarySearch {
    public static void main(String[] args) {
        int[] arr = {1,2,5,9};
        int limit = 8;
        int ans = smallest(arr,limit);
        System.out.println(ans);
    }

    private static int smallest(int[] arr, int limit) {
        int maxDivisor = Integer.MIN_VALUE;
        int ans = 0;
        for (int num : arr){
            maxDivisor = Math.max(maxDivisor,num);
        }
        int start = 1;
        int end = maxDivisor;
        while (start <= end){
            int mid = start + (end - start) / 2;
            int sum = sumAfterDividingByDivisors(arr,mid);
            if (sum <= limit){
                ans = mid;
                end = mid - 1;
            }else {
                start = mid + 1;
            }
        }
        return ans;
    }

    private static int sumAfterDividingByDivisors(int[] arr, int divisor) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++){
            sum = (int) (sum + (Math.ceil((double)(arr[i]) / (double)divisor)));
        }
        return sum;
    }
}
