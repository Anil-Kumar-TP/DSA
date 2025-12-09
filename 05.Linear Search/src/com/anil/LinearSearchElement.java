package src.com.anil;

import java.util.Optional;

public class LinearSearchElement {
    public static void main(String[] args) {
        int[] arr = {3,5,6,9,11,33,13,89};
        int target = 33;
        Optional<Integer> ans = linearSearch(arr,target);
        if (ans.isPresent()){
            System.out.println("Element found " + ans.get());
        }else {
            System.out.println("Element not found");
        }
    }

    private static Optional<Integer> linearSearch(int[] arr, int target) {
        if (arr.length == 0){
            return Optional.empty();
        }
       for (int element : arr){
           if (element == target){
               return Optional.of(element);
           }
       }
        return Optional.empty();
    }
}
