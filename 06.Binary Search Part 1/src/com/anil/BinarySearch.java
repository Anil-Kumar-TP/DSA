package src.com.anil;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {2,3,5,7,9,11,13,21,27};
        int target = 13;
        int ans = binarySearch(arr,target);
        System.out.println(ans);
    }

    private static int binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
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
