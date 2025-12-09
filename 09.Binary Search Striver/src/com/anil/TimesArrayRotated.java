package src.com.anil;

public class TimesArrayRotated {
    public static void main(String[] args) {
        int[] arr = {3, 4, 5, 1, 2};
        int ans = times(arr);
        System.out.println("Array has been rotated " + ans + " times");
    }

    private static int times(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        int minimum = Integer.MAX_VALUE;
        int minIndex = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[start] <= arr[end]) {
                if (arr[start] < minimum) {
                    minimum = arr[start];
                    minIndex = start;
                }
                break;
            }

//            qstn says distinct
//            if (arr[start] == arr[mid] && arr[mid] == arr[end]) {
//                start++;
//                end--;
//                continue;
//            }

            if (arr[start] <= arr[mid]) {
                if (arr[start] < minimum) {
                    minimum = arr[start];
                    minIndex = start;
                }
                start = mid + 1;
            } else {
                if (arr[mid] < minimum) {
                    minimum = arr[mid];
                    minIndex = mid;
                }
                end = mid - 1;
            }
        }
        return minIndex;
    }
}
