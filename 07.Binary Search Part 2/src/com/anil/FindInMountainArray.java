package src.com.anil;

public class FindInMountainArray {
    public static void main(String[] args) {
        int[] arr = {1,2,4,6,5,3,1};
        int target = 3;
        int ans = find(arr,target);
        System.out.println(ans);
    }

    private static int find(int[] arr, int target) {
        int peak = peak(arr);
        int firstPart = orderAgnostic(arr,target,0,peak);
        if (firstPart != -1){
            return firstPart;
        }
        return orderAgnostic(arr,target,peak + 1,arr.length - 1);
    }

    private static int orderAgnostic(int[] arr, int target, int start, int end) {
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

    private static int peak(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end){
            int mid = start + (end - start) / 2;
            if (arr[mid] > arr[mid + 1]){
                end = mid;
            }else {
                start = mid + 1;
            }
        }
        return start;
    }
}
