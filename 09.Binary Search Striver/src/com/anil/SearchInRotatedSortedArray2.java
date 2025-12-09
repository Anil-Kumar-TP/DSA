package src.com.anil;

public class SearchInRotatedSortedArray2 {
    public static void main(String[] args) {
        int[] arr = {7, 8, 1, 2, 3, 3, 3, 4, 5, 6};
        int target = 2;
        boolean ans = searchWithDuplicates(arr,target);
        System.out.println(ans);
    }

    private static boolean searchWithDuplicates(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end){
            int mid = start + (end - start) / 2;
            if (arr[mid] == target){
                return true;
            }
            //if mid is not the target and start and end are same as mid,then they too are not the ans
            //so skip those
            //continue is there to prevent the code to move to next loop
            //we have to recalculate the start,mid and end now that we have skipped
            //so continue
            if (arr[start] == arr[mid] && arr[mid] == arr[end]){
                start++;
                end--;
                continue;
            }
            if (arr[start] <= arr[mid]){
                if (arr[start] <= target && target <= arr[mid]){
                    end = mid - 1;
                }else {
                    start = mid + 1;
                }
            }else {
                if (arr[mid] <= target && target <= arr[end]){
                    start = mid + 1;
                }else {
                    end = mid - 1;
                }
            }
        }
        return false;
    }
}
