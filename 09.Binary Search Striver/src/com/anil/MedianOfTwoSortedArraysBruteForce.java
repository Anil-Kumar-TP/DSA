package src.com.anil;

public class MedianOfTwoSortedArraysBruteForce {
    public static void main(String[] args) {
        int[] arr1 = {1, 4, 7, 10, 12};
        int[] arr2 = {2, 3, 6, 15};
        double ans = median(arr1,arr2);
        System.out.println(ans);
    }

    private static double median(int[] arr1, int[] arr2) {
        int[] arr3 = new int[arr1.length + arr2.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < arr1.length && j < arr2.length){
            if (arr1[i] < arr2[j]){
                arr3[k] = arr1[i];
                k++;
                i++;
            }else {
                arr3[k] = arr2[j];
                k++;
                j++;
            }
        }
        while (i < arr1.length){
            arr3[k] = arr1[i];
            k++;
            i++;
        }
        while (j < arr2.length){
            arr3[k] = arr2[j];
            k++;
            j++;
        }

        int n = arr3.length;
        if (n % 2 == 1){
            return arr3[n / 2];
        }else {
            return (arr3[n / 2] + arr3[(n / 2) - 1]) / 2.0;
        }
    }
}
