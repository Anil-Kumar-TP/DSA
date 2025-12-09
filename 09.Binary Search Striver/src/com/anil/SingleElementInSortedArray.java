package src.com.anil;

public class SingleElementInSortedArray {
    public static void main(String[] args) {
        int[] arr = {1,1,2,2,3,3,4,5,5,6,6};
        int ans = single(arr);
        System.out.println(ans);
    }

    private static int single(int[] arr) {

        if (arr.length == 1){
            return arr[0];
        }

        if (arr[0] != arr[1]){
            return arr[0];
        }

        if (arr[arr.length - 1] != arr[arr.length - 2]){
            return arr[arr.length - 1];
        }

        int start = 1;
        int end = arr.length - 2;
        while (start <= end){
            int mid = start + (end - start) / 2;
            if (arr[mid] != arr[mid - 1] && arr[mid] != arr[mid + 1]){
                return arr[mid];
            }
            //elimination
            if (mid % 2 == 1 && arr[mid] == arr[mid - 1] || mid % 2 == 0 && arr[mid] == arr[mid + 1]){
                start = mid + 1;
            }else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
