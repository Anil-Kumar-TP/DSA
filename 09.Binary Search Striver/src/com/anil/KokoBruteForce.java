package src.com.anil;

public class KokoBruteForce {
    public static void main(String[] args) {
        int[] arr = {7, 15, 6, 3};
        int h = 8;
        int ans = koko(arr,h);
        System.out.println(ans);
    }

    private static int koko(int[] arr, int h) {
        int max = findMax(arr);
        for (int k = 1; k <= max; k++){
            int totalHours = time(arr,k);
            if (totalHours <= h){
                return k;
            }
        }
        return max;
    }

    private static int time(int[] arr, int k) {
        int time = 0;
        for (int i = 0; i < arr.length; i++){
            time = (int) (time + Math.ceil((double)arr[i] / (double)k));
        }
        return time;
    }

    private static int findMax(int[] arr) {
        int max =  Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++){
            max = Math.max(max,arr[i]);
        }
        return max;
    }
}
