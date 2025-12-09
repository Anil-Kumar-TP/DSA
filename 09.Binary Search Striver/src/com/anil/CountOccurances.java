package src.com.anil;

public class CountOccurances {
    public static void main(String[] args) {
        int[] arr = {5,7,7,8,8,10};
        int target = 8;
        int ans = countOccurances(arr,target);
        System.out.println(ans);
    }

    private static int countOccurances(int[] arr, int target) {
        int[] ans = firstAndLast(arr,target);
        if (ans[0] == -1){
            return 0;//element not existing
        }
        return ans[1] - ans[0] + 1;
    }

    private static int[] firstAndLast(int[] arr, int target) {
        int first = firstOccurance(arr,target);
        if (first == -1){
            return new int[]{-1,-1};
        }
        int second = secondOccurance(arr,target);
        return new int[]{first,second};
    }

    private static int secondOccurance(int[] arr, int target) {
        int second = -1;
        int start = 0;
        int end = arr.length - 1;
        while (start <= end){
            int mid = start + (end - start) / 2;
            if (arr[mid] == target){
                second = mid;
                start = mid + 1;
            }else if (arr[mid] < target){
                start = mid + 1;
            }else {
                end = mid - 1;
            }
        }
        return second;
    }

    private static int firstOccurance(int[] arr, int target) {
        int first = -1;
        int start = 0;
        int end = arr.length - 1;
        while (start <= end){
            int mid = start + (end - start) / 2;
            if (arr[mid] == target){
                first = mid;
                end = mid - 1;
            }else if (arr[mid] > target){
                end = mid - 1;
            }else {
                start = mid + 1;
            }
        }
        return first;
    }
}
