package src.com.anil;

public class MaxInRange {
    public static void main(String[] args) {
        int[] arr = {32,13,45,97,11,444,12,189};
        System.out.println(maxInRange(arr,1,6));
    }

    private static int maxInRange(int[] arr, int start, int end) {
        if (end < start) return -1;
        int max = arr[start];
        for (int i = start; i <= end; i++){
            if (arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }
}
