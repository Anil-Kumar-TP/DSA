package src.com.anil;

public class KokoBinarySearch {
    public static void main(String[] args) {
        int[] arr = {7, 15, 6, 3};
        int h = 8;
        int ans = koko(arr,h);
        System.out.println(ans);
    }

    private static int koko(int[] arr, int h) {
        int max = findMax(arr);
        int start = 1;
        int end = max;
        int ans = max;
        while (start <= end){
            int mid = start + (end - start) / 2;
            int timeTaken = time(arr,mid);
            if (timeTaken <= h){
                ans = mid;
                end = mid - 1;
            }else {
                start = mid + 1;
            }
        }
        return ans;
    }

    private static int time(int[] arr, int mid) {
        int totalHours = 0;
        for (int i = 0; i < arr.length; i++){
            totalHours = (int) (totalHours + Math.ceil((double)arr[i] / (double)mid));
        }
        return totalHours;
    }

    private static int findMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int num : arr){
            max = Math.max(max,num);
        }
        return max;
    }
}
