package com.anil.src;

import java.util.ArrayList;
import java.util.List;

public class PermutationsOther {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        List<List<Integer>> list = new ArrayList<>();
        permutation(arr,0,list);
        System.out.println(list);
    }

    private static void permutation(int[] arr, int index, List<List<Integer>> list) {
        if (index == arr.length){
            List<Integer> path = new ArrayList<>();
            for (int num : arr){
                path.add(num);
            }
            list.add(new ArrayList<>(path));//Snapshot the array only when it's complete
            return;
        }

        for (int i = index; i < arr.length; i++){
            swap(arr,index,i);
            permutation(arr,index + 1,list);//note in permutations it is index + 1 and not i + 1
            swap(arr,index,i);//You are fixing positions, not elements.so index + 1.
        }
    }

    private static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}


// WHY permutations (swap method) DO NOT need a path parameter
//
//        Because:
//
//        In permutations, the array itself becomes the path.
//
//        You are mutating the array in-place via swaps to reflect the current partial permutation.

//
//
//# Why the Permutation Backtracking Actually Works
//        (The version you’ll actually remember forever)
//
//        Array: [1, 2, 3]
//
//        We call: permute(arr, index = 0)
//
//        Goal at every step:
//        “Fix position `index` → then recurse to fix position `index + 1`”
//
//        ### Depth 0 – Who gets seat 0?
//
//        We try every candidate from position 0 onward:
//
//        1. i = 0 → swap(0,0) → array stays [1,2,3] → recurse with index=1
//        2. i = 1 → swap(0,1) → array becomes [2,1,3] → recurse with index=1
//        3. i = 2 → swap(0,2) → array becomes [3,2,1] → recurse with index=1
//
//        Let’s follow the second branch (starts with 2):
//        → [2,1,3], now fixing index = 1
//
//        ### Depth 1 – Who gets seat 1? (first element already fixed as 2)
//
//        We only choose from position 1 onward:
//
//        1. i = 1 → swap(1,1) → no change, still [2,1,3] → recurse with index=2
//        2. i = 2 → swap(1,2) → becomes [2,3,1] → recurse with index=2
//
//        Let’s follow the first sub-branch (second element = 1):
//        → [2,1,3], now fixing index = 2
//
//        ### Depth 2 – Who gets seat 2?
//
//        Only one choice left:
//
//        i = 2 → swap(2,2) → no change → [2,1,3] → recurse with index=3
//
//        ### Depth 3 – Base case
//
//        index == 3 → full permutation!
//        Add [2,1,3] to result → backtrack (undo swaps) → explore other paths
//
//        ### The Million-Dollar Question: Why does `i` start at `index`?
//
//        Because:
//
//        - `index` = the seat we’re currently assigning (fixed for this entire recursive call)
//        - `i`     = the person we’re trying in that seat (loops over everyone still available, i.e. from `index` to the end)
//
//        They are only equal on the very first try of each level.
//
//        Every time `i > index`, we pull a later element forward → that’s literally what creates new unique permutations.
//
//        One sentence to tattoo on your brain:
//
//        > “`index` tells you which position you’re filling.
//        > `i` tells you which remaining number you’re testing in that position.”
//
//        That’s it. That’s the entire algorithm.

