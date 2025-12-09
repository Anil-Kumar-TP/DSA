package src.com.anil;

public class InfiniteNumbers {
    public static void main(String[] args) {
        int[] arr = {3,5,7,9,10,90,130,180,200};
        int target = 9;
        int ans = infinite(arr,target);
        System.out.println(ans);
    }

    private static int infinite(int[] arr, int target) {
        int start = 0;
        int end = 1;
        while (target > arr[end]){
            int newStart = end + 1;
            end = end + (end - start + 1) * 2;
            start = newStart;
        }
        return binarySearch(arr,target,start,end);
    }

    private static int binarySearch(int[] arr, int target, int start, int end) {
        while (start <= end){
            int mid = start + (end - start) / 2;
            if (target < arr[mid]){
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            }else {
                return mid;
            }
        }
        return -1;
    }
}
