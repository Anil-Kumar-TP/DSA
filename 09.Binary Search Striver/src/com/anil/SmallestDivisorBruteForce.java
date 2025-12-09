package src.com.anil;

public class SmallestDivisorBruteForce {
    public static void main(String[] args) {
        int[] arr = {1,2,5,9};
        int limit = 8;
        int ans = smallest(arr,limit);
        System.out.println(ans);
    }

    private static int smallest(int[] arr, int limit) {
        if (arr.length > limit){
            return -1;
        }
        int maxDivisor = Integer.MIN_VALUE;
        for (int num : arr){
            maxDivisor = Math.max(maxDivisor,num);
        }
        for (int divisor = 1; divisor <= maxDivisor; divisor++){
            int sum = 0;
            for (int i = 0; i < arr.length; i++){
                sum = (int) (sum + Math.ceil((double)(arr[i]) / (double)(divisor)));
            }
            if (sum <= limit){
                return divisor;
            }
        }
        return -1;
    }
}
