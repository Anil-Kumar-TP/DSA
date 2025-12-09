package src.com.anil;

public class OrderAgnosticBinarySearch {
    public static void main(String[] args) {
        int[] arr = {99,77,63,45,31,25,13,9,7};
        int target = 77;
        int ans = orderAgnostic(arr,target);
        System.out.println(ans);
    }

    private static int orderAgnostic(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        boolean isAsc = arr[start] < arr[end];
        while (start <= end){
            int mid = start + (end - start) / 2;
            if (target == arr[mid]){
                return mid;
            }
            if (isAsc){
                if (target < arr[mid]){
                    end = mid - 1;
                } else if (target > arr[mid]) {
                    start = mid + 1;
                }
            }else {
                if (target < arr[mid]){
                    start = mid + 1;
                } else if (target > arr[mid]) {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}
