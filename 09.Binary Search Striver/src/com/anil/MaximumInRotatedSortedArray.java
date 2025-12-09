package src.com.anil;

public class MaximumInRotatedSortedArray {
    public static void main(String[] args) {
        int[] arr = {3,4,5,1,2};
        int ans = maximum(arr);
        System.out.println("Max Index is " + ans);
        System.out.println("Maximum value is " + arr[ans]);
    }

    private static int maximum(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        int maximum = Integer.MIN_VALUE;
        int maxIndex = -1;
        while (start <= end){
            int mid = start + (end - start) / 2;
            if (arr[start] <= arr[end]){
                if (arr[end] > maximum){
                    maximum = arr[end];
                    maxIndex = end;
                }
                break;
            }
            if (arr[start] == arr[mid] && arr[mid] == arr[end]){
                start++;
                end--;
                continue;
            }

            if (arr[start] <= arr[mid]){
                if (arr[mid] > maximum){
                    maximum = arr[mid];
                    maxIndex = mid;
                }
                start = mid + 1;
            }else {
                if (arr[end] > maximum) {
                    maximum = arr[end];
                    maxIndex = end;
                }
                end = mid - 1;
            }
        }
        return maxIndex;
    }
}
