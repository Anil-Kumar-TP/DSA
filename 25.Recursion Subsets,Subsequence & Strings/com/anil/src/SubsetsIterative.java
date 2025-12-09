package com.anil.src;

import java.util.ArrayList;
import java.util.List;

public class SubsetsIterative {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        List<List<Integer>> ans = subsets(arr);
        System.out.println(ans);
    }

    private static List<List<Integer>> subsets(int[] arr) {
        // 'outer' is our result list, which collects all subsets.
        List<List<Integer>> outer = new ArrayList<>();

        // 1. Initialize the process by adding the empty set [[]].
        // The empty set is the foundation (the power set of an empty set).
        outer.add(new ArrayList<>());

        // 2. Process each number in the input array one by one.
        for (int num : arr){
            // CRITICAL STEP: Get the current size of 'outer'.
            // This represents all valid subsets generated from the previous numbers.
            int currentSize = outer.size();

            // 3. Iterate over ALL existing subsets found so far (from index 0 up to currentSize - 1).
            // We use the stored 'currentSize' to ensure we only loop over the ORIGINAL subsets
            // before we start adding the new ones in this iteration.
            for (int i = 0; i < currentSize; i++){
                // Get the existing subset (e.g., [], [1], [2], [1,2] from previous steps)
                List<Integer> existingSubset = outer.get(i);

                // 4. Create the new subset by **COPYING** the existing one.
                // COPYING is necessary to preserve the original subset (the EXCLUDE path).
                List<Integer> newSubset = new ArrayList<>(existingSubset);

                // 5. Add the current number 'num' to the new copy (the INCLUDE path).
                newSubset.add(num);


                // 6. Add the newly created subset to the result list.
                outer.add(newSubset);
            }
        }
        return outer;
    }
}


//    Think of the main list as a container of everything generated so far:
//
//        Start: [ [] ] → only the empty subset exists
//
//        Add 1 → make a copy of all subsets, add 1 → merge → [ [], [1] ]
//
//        Add 2 → copy all subsets [ [], [1] ], add 2 → [ [2], [1,2] ] → merge → [ [], [1], [2], [1,2] ]
//
//        Add 3 → copy [ [], [1], [2], [1,2] ], add 3 → [ [3], [1,3], [2,3], [1,2,3] ] → merge → [ [], [1], [2], [1,2], [3], [1,3], [2,3], [1,2,3] ]
//
//        Each element’s processing reuses all subsets generated so far, just like recursion unwinding produces all combinations.

//
//    That is the single most important conceptual difference between the recursive (backtracking) and the iterative (expansion) approaches!You are exactly right: in the recursive method, you never explicitly copied the previous subsets. In the iterative method, copying is absolutely necessary.Here is why:1. 🔙 The Recursive Method: Shared, Mutable StateIn the recursive approach, you use a single, shared list, the inner list, and you manage its state across the call stack using two actions:Modification: inner.add(arr[index]);Restoration: inner.remove(inner.size() - 1); (Backtracking)The magic is that the choices (or "subsets") are implied by the path you take down the call tree, and you only finalize (copy and save) the inner list at the base case.ScenarioWhat Happens"Include"You modify inner in place and recurse. The subsequent levels see the change immediately."Exclude"You undo the change via backtracking, restoring inner to its previous state for the next branch.The recursive call stack keeps track of all the intermediate states, and the backtracking step ensures that the single inner list is clean before exploring the next branch of the tree. There is no need to copy because you are either building on the current state or resetting it.2. 🔁 The Iterative Method: Immutable, Finalized SubsetsThe iterative method throws away the recursive call stack and the backtracking mechanism. It works entirely with the final, complete subsets generated so far.At the beginning of each iteration (e.g., when processing the number 2), the outer list contains all the final, correct subsets for the numbers processed so far ({1}).outer = [ [], [1] ] (Final subsets for $\{1\}$)New number to process: $N=2$.If you simply iterated through outer and added 2 without copying, you would destroy the original subsets:ActionResult if NO COPYINGOutcome (Incorrect!)Take [] and add 2[] becomes [2]The original empty set is lost/modified.Take [1] and add 2[1] becomes [1, 2]The original set [1] is lost/modified.Why Copying is Required:Preservation: You must preserve the subsets from the previous step ([], [1]) because they are valid subsets of the final array that exclude the current number.Creation: You must create new subsets ([2], [1, 2]) which are the exact copies that include the current number.The iterative approach uses explicit copying to achieve what recursion achieves implicitly through the stack and backtracking: generating two distinct paths (Include and Exclude) from every prior state.


//
//✅ Initial State
//        arr = [1, 2, 3]
//
//        outer = [ [] ]
//
//        ✅ Process num = 1
//        Before loop
//        outer = [ [] ]
//        currentSize = 1
//
//        Loop over i = 0
//
//        existingSubset = []
//
//        newSubset = copy → []
//
//        add 1 → [1]
//
//        outer.add → [1]
//
//        After finishing num = 1
//        outer = [ [], [1] ]
//
//        ✅ Process num = 2
//        Before loop
//        outer = [ [], [1] ]
//        currentSize = 2
//
//        Loop over i = 0
//
//        existingSubset = []
//
//        newSubset = copy → []
//
//        newSubset.add(2) → [2]
//
//        outer.add → [2]
//
//        Loop over i = 1
//
//        existingSubset = [1]
//
//        newSubset = copy → [1]
//
//        newSubset.add(2) → [1,2]
//
//        outer.add → [1,2]
//
//        After finishing num = 2
//        outer = [ [], [1], [2], [1,2] ]
//
//        ✅ Process num = 3
//        Before loop
//        outer = [ [], [1], [2], [1,2] ]
//        currentSize = 4
//
//        Loop over i = 0
//
//        existingSubset = []
//
//        newSubset = [3]
//
//        add to outer
//
//        outer = [ [], [1], [2], [1,2], [3] ]
//
//        Loop over i = 1
//
//        existingSubset = [1]
//
//        newSubset = [1,3]
//
//        add to outer
//
//        outer = [ [], [1], [2], [1,2], [3], [1,3] ]
//
//        Loop over i = 2
//
//        existingSubset = [2]
//
//        newSubset = [2,3]
//
//        add to outer
//
//        outer = [ [], [1], [2], [1,2], [3], [1,3], [2,3] ]
//
//        Loop over i = 3
//
//        existingSubset = [1,2]
//
//        newSubset = [1,2,3]
//
//        add to outer
//
//        outer = [ [], [1], [2], [1,2], [3], [1,3], [2,3], [1,2,3] ]