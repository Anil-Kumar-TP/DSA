package src.com.anil;

public class PaintersPartitionBinarySearch {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40};
        int k = 2;
        int ans = partition(arr,k);
        System.out.println(ans);
    }

    private static int partition(int[] arr, int k) {
        int minTimeToPaint = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < arr.length; i++){
            minTimeToPaint = Math.max(minTimeToPaint,arr[i]);
            sum = sum + arr[i];
        }
        int start = minTimeToPaint;
        int end = sum;
        int ans = -1;
        while (start <= end){
            int mid = start + (end - start) / 2;
            int painters = countPainters(arr,mid);
            if (painters <= k){
                ans = mid;
                end = mid - 1;
            }else {
                start = mid + 1;
            }
        }
        return ans;
    }

    private static int countPainters(int[] arr, int time) {
            int painters = 1;
            int boardsPainted = 0;
            for (int i = 0; i < arr.length; i++){
                if (arr[i] + boardsPainted <= time){
                    boardsPainted = boardsPainted + arr[i];
                }else {
                    painters = painters + 1;
                    boardsPainted = arr[i];
                }
            }
            return painters;
        }

}
