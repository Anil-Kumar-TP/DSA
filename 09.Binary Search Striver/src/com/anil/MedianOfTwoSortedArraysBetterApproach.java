package src.com.anil;

public class MedianOfTwoSortedArraysBetterApproach {
    public static void main(String[] args) {
        int[] arr1 = {1,2,4,7,9};
        int[] arr2 = {5,8,9,10,12};
        double ans = median(arr1,arr2);
        System.out.println(ans);
    }

    private static double median(int[] arr1, int[] arr2) {
        int i = 0;
        int j = 0;
        int index2 = (arr1.length + arr2.length) / 2;
        int index1 = index2 - 1;
        int index1Element = -1;
        int index2Element = -1;
        int count = 0;
        while (i < arr1.length && j < arr2.length){
            if (arr1[i] < arr2[j]){
                if (count == index1){
                    index1Element = arr1[i];
                }
                if (count == index2){
                    index2Element = arr1[i];
                }
                count++;
                i++;
            }else {
                if (count == index1){
                    index1Element = arr2[j];
                }
                if (count == index2){
                    index2Element = arr2[j];
                }
                count++;
                j++;
            }
        }

        while (i < arr1.length){
            if (count == index1){
                index1Element = arr1[i];
            }
            if (count == index2){
                index2Element = arr1[i];
            }
            count++;
            i++;
        }

        while (j < arr2.length){
            if (count == index1){
                index1Element = arr2[j];
            }
            if (count == index2){
                index2Element = arr2[j];
            }
            count++;
            j++;
        }

        int n = arr1.length + arr2.length;
        if (n % 2 == 1){
            return (double)index2Element;
        }

        return (double)((double)(index1Element + index2Element)) / 2.0;

    }
}
