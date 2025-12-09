package com.anil.src;

import java.util.ArrayList;
import java.util.List;

public class KthPermutationSequence {
    public static void main(String[] args) {
        int n = 4;
        int k = 17;
        String ans = getPermutations(n,k);
        System.out.println(ans);
    }

    private static String getPermutations(int n, int k) {
        int factorial = 1;
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i < n; i++){
            factorial = factorial * i; //for the 1st iteration we need factorial to be 6
            numbers.add(i);//add numbers from 1 to 3 in the list.outside the loop add 4 also.
        }
        numbers.add(n); //this is added at the end to avoid incorrect factorial calculation.
        StringBuilder ans = new StringBuilder();
        k = k - 1;
        while (true){
            ans.append(numbers.get(k / factorial));
            numbers.remove(k / factorial);
            if (numbers.size() == 0){
                break;
            }
            k = k % factorial;
            factorial = factorial / numbers.size(); //need fact updation as we removed one element
        }//so when we fix next element,factorial changes.
        return ans.toString();
    }
}
