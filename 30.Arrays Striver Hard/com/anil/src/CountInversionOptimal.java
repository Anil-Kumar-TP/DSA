package com.anil.src;

public class CountInversionOptimal {
    public static void main(String[] args) {
        int[] arr = {5,3,2,4,1};
        int ans = countInversion(arr);
        System.out.println(ans);
    }

    private static int countInversion(int[] arr) {
        return mergeSort(arr,0,arr.length - 1);
    }

    private static int mergeSort(int[] arr, int low, int high) {
        int count = 0;

        if (low >= high){
            return count;
        }

        int mid = (low + high) / 2;

        // Count inversions in left half
        count = count + mergeSort(arr,low,mid);

        // Count inversions in right half
        count = count + mergeSort(arr,mid + 1,high);

        // Count inversions during merge
        count = count + merge(arr,low,mid,high);

        return count;
    }

    private static int merge(int[] arr, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];

        int left = low;
        int right = mid + 1;
        int k = 0;

        // Variable to count inversions
        int count = 0;

        // Merge elements in sorted order
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp[k++] = arr[left++];
            } else {
                temp[k++] = arr[right++];
                count += (mid - left + 1); // Count inversions
            }
        }

        // Copy remaining elements of left half
        while (left <= mid) {
            temp[k++] = arr[left++];
        }

        // Copy remaining elements of right half
        while (right <= high) {
            temp[k++] = arr[right++];
        }

        // Copy back to original array
        int index = 0;
        for (int i = low; i <= high; i++) {
            arr[i] = temp[index];
            index++;
        }

        return count;
    }
}

//if we dont want to modify the callers array create a copy
//public int numberOfInversions(int[] arr) {
//    int[] copy = Arrays.copyOf(arr, arr.length);
//    return mergeSort(copy, 0, copy.length - 1);
//}
//The original input array remains unchanged
//
//The algorithm is free to destroy copy
//
//Caller safety is preserved

//but in the end copy back to original array,that cant be avoidable.


//Array:
//
//        [5, 3, 2, 4, 1]
//
//Top level
//Left  = [5, 3, 2]
//Right = [4, 1]
//
//Left side inversions
//
//Inside [5, 3, 2]:
//
//        (5,3), (5,2), (3,2) → 3
//
//Right side inversions
//
//Inside [4,1]:
//
//        (4,1) → 1
//
//Split inversions
//
//Between left and right:
//
//        (5,4), (5,1),
//        (3,1),
//        (2,1) → 4
//
//Total inversions:
//        3 + 1 + 4 = 8
//
//
//        ⚠️ Merge alone only counts the 4 split inversions
//⚠️ mergeSort must collect everything
//
//5️⃣ Why not count everything only in merge?
//
//Because merge:
//
//Never sees (5,3) or (3,2)
//
//Those pairs never cross the mid boundary
//
//Recursive calls are mandatory.
