package src.com.anil;

public class PaintersPartitionBruteForce {
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
        for (int time = minTimeToPaint; time <= sum; time++){
            if (countPainters(arr,time) <= k){
                return time;
            }
        }
        return minTimeToPaint;
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
