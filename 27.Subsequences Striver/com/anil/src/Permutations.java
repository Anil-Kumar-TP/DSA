package com.anil.src;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        List<List<Integer>> list = new ArrayList<>();
        boolean[] freq = new boolean[arr.length];
        permutation(arr,freq,new ArrayList<>(),list);
        System.out.println(list);
    }

    private static void permutation(int[] arr, boolean[] freq,ArrayList<Integer> path, List<List<Integer>> list) {
        if (path.size() == arr.length){
            list.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < arr.length; i++){
            if (!freq[i]){
                freq[i] = true;
                path.add(arr[i]);
                permutation(arr,freq,path,list);
                path.remove(path.size() - 1);
                freq[i] = false;
            }
        }
    }
}

//i+1 destroys permutation exploration because it forbids revisiting earlier indices.
//Combinations / subsets:
//
//        You avoid repeating the same combinations
//
//        So you move forward with i+1
//
//        Permutations:
//
//        You want all orders
//
//        So you must restart from i = 0 every time
//
//        And use freq[] to block reused elements
//
//        This is why permutation recursion works without moving the index forward.



//    Permutation Example:Path: [1]The freq array is {T, F, F} (1 is used).When the loop hits i=0 (element 1), the if (!freq[i]) check is FALSE.Result: The algorithm skips element 1, ensuring we don't build [1, 1, ...].2. Forward Progress (Handled by the for loop/Indices)Job: To define which candidates the recursive function will consider for the next position.Permutations (Your Code):The for loop always starts at i = 0.The loop's progress (i++) ensures that the function iterates through ALL three indices (0, 1, 2) in every single recursive call.The function is asking, "What can I put in the next available slot? Is it index 0? Index 1? Index 2?"The freq array then immediately rejects any used element.Combinations/Subsets ($\boldsymbol{i+1}$ Logic):The for loop starts at start_index.The recursive call sets the next start_index to i + 1.Result: This structure forces the search to only look forward in the array, making it impossible to pick a smaller index later. This is what handles both the forward progress AND the constraint of avoiding duplicate groups.