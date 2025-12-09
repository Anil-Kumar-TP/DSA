package src.com.anil;

public class LinearSearchIndex {
    public static void main(String[] args) {
        int[] arr = {3,5,6,9,11,33,13,89};
        int target = 33;
        int ans = linearSearch(arr,target);
        System.out.println(ans);
    }

    private static int linearSearch(int[] arr, int target) {
        if (arr.length == 0){
            return -1;
        }
        for (int i = 0; i < arr.length; i++){
            if (arr[i] == target){
                return i;
            }
        }
        return -1;
    }
}
