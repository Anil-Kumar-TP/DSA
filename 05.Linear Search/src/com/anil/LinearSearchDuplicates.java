package src.com.anil;

public class LinearSearchDuplicates {
    public static void main(String[] args) {
        int[] arr = {2,3,4,5,3,7,3};
        int target = 3;
        int ans = linearSearch(arr,target);
        System.out.println(ans);
    }

    private static int linearSearch(int[] arr, int target) {
        int lastIndex = -1;
        if (arr.length == 0){
            return -1;
        }
        for (int i = 0; i < arr.length; i++){
            if (arr[i] == target){
                lastIndex = i;
            }
        }
        return lastIndex;
    }
}
