package src.com.anil;

import java.util.Arrays;

public class FirstAndLastPosition {
    public static void main(String[] args) {
        int[] arr = {2,7,7,7,7,8,8,10};
        int target = 7;
        int[] ans = position(arr,target);
        System.out.println(Arrays.toString(ans));
    }

    private static int[] position(int[] arr, int target) {
        int[] ans = {-1,-1};
        int start = search(arr,target,true);
        int end = search(arr,target,false);
        ans[0] = start;
        ans[1] = end;
        return ans;
    }

    private static int search(int[] arr, int target, boolean startIndex) {
        int start = 0;
        int end = arr.length - 1;
        int ans = -1;
        while (start <= end){
            int mid = start + (end - start) / 2;
            if (target > arr[mid]){
                start = mid + 1;
            }else if(target < arr[mid]){
                end = mid - 1;
            }else {
                ans = mid;
                if (startIndex){
                    end = mid - 1;
                }else {
                    start = mid + 1;
                }
            }
        }
        return ans;
    }
}
