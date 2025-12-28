package com.anil.src;

public class CountInversionBruteForce {
    public static void main(String[] args) {
        int[] arr = {5,3,2,4,1};
        int ans = countInversion(arr);
        System.out.println(ans);
    }

    private static int countInversion(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++){
            for (int j = i + 1; j < arr.length; j++){
                if (arr[i] > arr[j]){
                    count++;
                }
            }
        }
        return count;
    }
}

//here we can have the boundary of i from 0 to arr.length - 1 instead of arr.length.
//that will work as well,cus,if i == arr.length - 1,then j = arr.length. means a pair cannot exist
//so we can also tight up the boundary instead of wasting an iteration

//if we want the pairs and not just count

//public class CountInversionBruteForce {
//    public static void main(String[] args) {
//        int[] arr = {5, 3, 2, 4, 1};
//        List<List<Integer>> pairs = getInversionPairs(arr);
//        System.out.println(pairs);
//    }
//
//    private static List<List<Integer>> getInversionPairs(int[] arr) {
//        // We use a List because we don't know how many inversions exist beforehand
//        List<List<Integer>> result = new ArrayList<>();
//
//        for (int i = 0; i < arr.length - 1; i++) {
//            for (int j = i + 1; j < arr.length; j++) {
//                if (arr[i] > arr[j]) {
//                    // Create a small list for the pair and add to the main result
//                    result.add(Arrays.asList(arr[i], arr[j]));
//                }
//            }
//        }
//        return result;
//    }
//}