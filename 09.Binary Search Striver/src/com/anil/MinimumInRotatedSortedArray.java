package src.com.anil;

public class MinimumInRotatedSortedArray {
    public static void main(String[] args) {
        int[] arr = {3,4,5,1,2};
        int ans = minimum(arr);
        System.out.println("Min Index is " + ans);
        System.out.println("Minimum value is " + arr[ans]);
    }

    private static int minimum(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        int minimum = Integer.MAX_VALUE;
        int minIndex = -1;
        while (start <= end){
            int mid = start + (end - start) / 2;
            //for non-rotated arrays
            if (arr[start] <= arr[end]){
                if (arr[start] < minimum){
                    minimum = arr[start];
                    minIndex = start;
                }
                break;
            }
            //for duplicates
            if (arr[start] == arr[mid] && arr[mid] == arr[end]){
                start++;
                end--;
                continue;
            }
            ////left part sorted
            //true min on right.so mid + 1
            if (arr[start] <= arr[mid]){
                if (arr[start] < minimum){
                    minimum = arr[start];
                    minIndex = start;
                }
                start = mid + 1;
                //right part sorted
            }else {
                if (arr[mid] < minimum){
                    minimum = arr[mid];
                    minIndex = mid;
                }
                end = mid - 1;
            }
        }
        return minIndex;
    }
}


//    The minimum (the rotation point) is always inside the unsorted half.
//That’s the key property.
//
//That’s why the rule is:
//
//        If left part sorted → min in right part
//
//        If right part sorted → min in left part
