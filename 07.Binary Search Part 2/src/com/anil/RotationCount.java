package src.com.anil;

public class RotationCount {
    public static void main(String[] args) {
        int[] arr = {4,5,6,7,0,1,2};
        int ans = count(arr);
        System.out.println(ans);
    }

    private static int count(int[] arr) {
        int pivot = findPivot(arr);
        return pivot + 1;
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
