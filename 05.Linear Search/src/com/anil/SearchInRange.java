package src.com.anil;

public class SearchInRange {
    public static void main(String[] args) {
        int[] arr = {33,54,13,23,78,99};
        int target = 13;
        int ans = linearSearch(arr,target,1,4);
        System.out.println(ans);
    }

    private static int linearSearch(int[] arr, int target, int start, int end) {
        if (arr.length == 0){
            return -1;
        }
        for (int i = start; i <= end; i++){
            if (arr[i] == target){
                return i;
            }
        }
        return -1;
    }
}
