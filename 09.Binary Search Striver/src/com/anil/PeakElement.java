package src.com.anil;

public class PeakElement {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 5, 1};
        int ans = peak(arr);
        System.out.println(ans);
    }

    private static int peak(int[] arr) {
        if (arr.length == 1){
            return 0;
        }
        if (arr[0] > arr[1]){
            return 0;
        }
        if (arr[arr.length - 1] > arr[arr.length - 2]){
            return arr.length - 1;
        }
        int start = 1;
        int end = arr.length - 2;
        while (start <= end){
            int mid = start + (end - start) / 2;
            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]){
                return mid;
            }
            if (arr[mid] > arr[mid - 1]){
                start = mid + 1;
            }else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
