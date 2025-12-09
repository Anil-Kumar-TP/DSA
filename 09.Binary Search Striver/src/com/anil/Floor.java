package src.com.anil;

public class Floor {
    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 5, 5, 9, 14};
        int target = 5;
        int ans = floor(arr,target);
        System.out.println(ans);
    }

    private static int floor(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        int ans = -1;
        while (start <= end){
            int mid = start + (end - start) / 2;
            if (arr[mid] <= target){
                ans = mid;
                start = mid + 1;
            }else {
                end = mid - 1;
            }
        }
        return ans == arr.length ? -1 : ans;
    }
}
