package src.com.anil;

public class MaxInArray {
    public static void main(String[] args) {
        int[] arr = {32,13,45,97,11};
        System.out.println(max(arr));
    }

    private static int max(int[] arr) {
        int max = arr[0];
        for (int i = 0; i < arr.length; i++){
            if (arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }
}
