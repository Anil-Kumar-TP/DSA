package src.com.anil;

public class SearchInRotatedSortedArrayDuplicates {
    public static void main(String[] args) {
        int[] arr = {2, 2, 2, 3, 4, 5, 1};
        int target = 5;
        int ans = rotate(arr,target);
        System.out.println(ans);
    }

    private static int rotate(int[] arr, int target) {
        int pivot = findPivot(arr);
        if (pivot == -1){
            return binarySearch(arr,target,0,arr.length - 1);
        }
        if (arr[pivot] == target){
            return pivot;
        }
        if (arr[0] >= target){
            return binarySearch(arr,target,pivot + 1,arr.length - 1);
        }
        return binarySearch(arr,target,0,pivot - 1);
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

    private static int findPivot(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end){
            int mid = start + (end - start) / 2;
            if (mid < end && arr[mid] > arr[mid + 1]){
                return mid;
            }
            if (mid > start && arr[mid - 1] > arr[mid]){
                return mid - 1;
            }
            if (arr[start] == arr[mid] && arr[mid] == arr[end]){
                if (start < end && arr[start] > arr[start + 1]){
                    return start;
                }
                start++;
                if (end > start && arr[end - 1] > arr[end]){
                    return end;
                }
                end--;
            }else if (arr[start] < arr[mid] || arr[start] == arr[mid] && arr[mid] > arr[end]){
                start = mid + 1;
            }else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
