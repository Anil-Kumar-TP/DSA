package src.com.anil;

public class KthMissingPositiveNumberBinarySearch {
    public static void main(String[] args) {
        int[] arr = {4, 7, 9, 10};
        int k = 4;
        int ans = missing(arr, k);
        System.out.println(ans);
    }

    private static int missing(int[] arr, int k) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int missingNumbers = arr[mid] - (mid + 1);
            if (missingNumbers < k) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return end + k + 1;
    }
}
