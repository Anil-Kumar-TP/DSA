package src.com.anil;

public class LowerBound {
    public static void main(String[] args) {
        int[] arr = {3, 5, 8, 15, 19};
        int target = 17;
        int ans = lowerBound(arr,target);
        System.out.println(ans);
    }

    private static int lowerBound(int[] arr, int target) {
        if (arr.length == 0){
            return -1;
        }
        int start = 0;
        int end = arr.length - 1;
        int ans = arr.length;
        while (start <= end){
            int mid = start + (end - start) / 2;
            if (arr[mid] >= target){
                ans = mid;
                end = mid - 1;
            }else {
                start = mid + 1;
            }
        }
        return ans;
    }
}
