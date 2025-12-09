package com.anil.src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//
//“When skipping the EXCLUDE branch, identical elements must be jumped over as a block to avoid duplicate subsets.”

//The rule is: To form a unique set, the first instance of any number must be the "gatekeeper" for that number.If you INCLUDE the first '2', you've opened the door for all subsets containing '2', including $\{2, 2\}$. (This is the necessary path).If you EXCLUDE the first '2', you must skip the second '2' entirely. If you didn't skip it, the second '2' would run its INCLUDE branch, creating the redundant $\{2\}$ se

//Since the redundancy only occurs when you decide to EXCLUDE the first instance of a duplicated number, the fix goes into the EXCLUDE branch.
//
//        Prerequisite: The input must be sorted so all duplicates are adjacent.
//
//        The Action: Instead of moving from index to index + 1 in the EXCLUDE branch, we must find the next unique starting number.
//
//        The Code: This translates directly to the loop:

// Start looking at the element after the current one.
//int nextUniqueIndex = index + 1;
//
//// As long as we find duplicates, keep moving forward.
//        while (nextUniqueIndex < arr.length && arr[nextUniqueIndex] == arr[index]) {
//        nextUniqueIndex++; // Skip the duplicate
//        }
//
//// Now, recurse from the first non-duplicate number.
//        subsets(arr, nextUniqueIndex, inner, outer);

//This while loop is the physical manifestation of the conceptual rule: "If I exclude this number, I must exclude all of its siblings in this group."

//Your focus should be: When I encounter a backtracking problem with duplicates, my initial two branches are "Include" and "Exclude." I must remember that the Exclude branch needs a special check (the sorting and the while loop) to leapfrog over identical elements and prevent redundant work.
public class SubsetsRecursiveDuplicates {
    
    public static void main(String[] args) {
        int[] arr = {1, 2, 2};
        Arrays.sort(arr); // Must sort first!
        List<List<Integer>> ans = new ArrayList<>();
        subsets(arr, 0, new ArrayList<Integer>(), ans);
        System.out.println("Result: " + ans);
    }

    private static void subsets(int[] arr, int index, List<Integer> inner, List<List<Integer>> outer) {
        
        // Base Case: If the index is past the end of the array, a complete subset is formed.
        if (index == arr.length) {
            outer.add(new ArrayList<>(inner));
            return;
        }

        // --- 1. INCLUDE Branch (Take the current element) ---
        // This is always done, regardless of whether it's a duplicate or not.
        inner.add(arr[index]);
        subsets(arr, index + 1, inner, outer); // Move to the next index
        
        // Backtrack: Undo the inclusion to reset the 'inner' list for the EXCLUDE path.
        inner.remove(inner.size() - 1);

        // --- 2. EXCLUDE Branch (Skip the current element AND its duplicates) ---
        
        // Find the next unique starting point. Start checking from the element *after* the current one.
        int nextUniqueIndex = index + 1; 
        
        // This loop embodies your clear logic: "Move forward until I find something not equal to arr[index]."
        // It skips all identical neighbors of arr[index].
        while (nextUniqueIndex < arr.length && arr[nextUniqueIndex] == arr[index]) {
            nextUniqueIndex++;
        }
        
        // Recurse: Start the recursion from the element that is unique (or the end of the array).
        // The 'inner' list remains unchanged (as it was before the INCLUDE step).
        subsets(arr, nextUniqueIndex, inner, outer);
    }
}




//Let's use arr = {1, 2, 2}. The outer list starts empty [].
//
//        1. Initial Call: subsets(arr, 0, [], outer) (Node: (0, []))
//
//        Current state: index = 0, arr[0] = 1, inner = []
//
//        / INCLUDE 1 Branch:
//
//        inner becomes [1].
//
//        Recursive call: subsets(arr, 1, [1], outer) (Node: (1, [1]))
//
//        Current state: index = 1, arr[1] = 2, inner = [1]
//
//        / INCLUDE 2 Branch:
//
//        inner becomes [1, 2].
//
//        Recursive call: subsets(arr, 2, [1, 2], outer) (Node: (2, [1, 2]))
//
//        Current state: index = 2, arr[2] = 2, inner = [1, 2]
//
//        / include 2 Branch:
//
//        inner becomes [1, 2, 2].
//
//        Recursive call: subsets(arr, 3, [1, 2, 2], outer) (Node: (3, [1, 2, 2]))
//
//        Base Case: index == arr.length (3 == 3).
//
//        Add new ArrayList<>(inner) to outer.
//
//        outer is now [[1, 2, 2]].
//
//        add (This means the (3,[1,2,2]) node completes and adds [1,2,2]).
//
//        Backtrack: inner removes 2, becomes [1, 2]. (Returns to (2, [1,2]) to continue after this INCLUDE call)
//
//        \ exclude dup2 Branch: (This is the second call from (2, [1, 2]))
//
//        Here's where the duplicate skip logic for arr[2] (2) kicks in.
//
//        while (nextUniqueIndex < arr.length && arr[nextUniqueIndex] == arr[index])
//
//        index = 2, arr[index] = 2.
//
//        nextUniqueIndex starts at index + 1 = 3.
//
//        nextUniqueIndex = 3 is not less than arr.length (which is 3). So the while loop condition nextUniqueIndex < arr.length is false.
//
//        This means nextUniqueIndex remains 3.
//
//        Recursive call: subsets(arr, 3, [1, 2], outer) (Node: (3, [1, 2]))
//
//        Base Case: index == arr.length (3 == 3).
//
//        Add new ArrayList<>(inner) to outer.
//
//        outer is now [[1, 2, 2], [1, 2]].
//
//        add (This means (3,[1,2]) node completes and adds [1,2]).
//
//        Backtrack: inner removes 2, becomes [1]. (Returns to (1, [1]) to continue after this INCLUDE branch)
//
//        \ EXCLUDE 2 Branch: (This is the second call from (1, [1]), after the previous INCLUDE 2 branch completed and backtracked)
//
//        Here's where the duplicate skip logic for arr[1] (2) kicks in.
//
//        while (nextUniqueIndex < arr.length && arr[nextUniqueIndex] == arr[index])
//
//        index = 1, arr[index] = 2.
//
//        nextUniqueIndex starts at index + 1 = 2.
//
//        arr[2] is 2, which is equal to arr[1]. So nextUniqueIndex becomes 3.
//
//        nextUniqueIndex = 3 is not less than arr.length. Loop ends.
//
//        nextUniqueIndex is now 3.
//
//        Recursive call: subsets(arr, 3, [1], outer) (Node: (3, [1]))
//
//        Base Case: index == arr.length (3 == 3).
//
//        Add new ArrayList<>(inner) to outer.
//
//        outer is now [[1, 2, 2], [1, 2], [1]].
//
//        add
//
//        Backtrack: inner removes 1, becomes []. (Returns to (0, []) to continue after this INCLUDE branch)
//
//        \ EXCLUDE 1 Branch: (This is the second call from (0, []), after the previous INCLUDE 1 branch completed and backtracked)
//
//        Here's where the duplicate skip logic for arr[0] (1) kicks in.
//
//        while (nextUniqueIndex < arr.length && arr[nextUniqueIndex] == arr[index])
//
//        index = 0, arr[index] = 1.
//
//        nextUniqueIndex starts at index + 1 = 1.
//
//        arr[1] is 2, which is not equal to arr[0]. Loop condition arr[nextUniqueIndex] == arr[index] is false.
//
//        nextUniqueIndex remains 1.
//
//        Recursive call: subsets(arr, 1, [], outer) (Node: (1, []))
//
//        Current state: index = 1, arr[1] = 2, inner = []
//
//        / INCLUDE 2 Branch:
//
//        inner becomes [2].
//
//        Recursive call: subsets(arr, 2, [2], outer) (Node: (2, [2]))
//
//        Current state: index = 2, arr[2] = 2, inner = [2]
//
//        / include2 Branch:
//
//        inner becomes [2, 2].
//
//        Recursive call: subsets(arr, 3, [2, 2], outer) (Node: (3, [2, 2]))
//
//        Base Case: index == arr.length (3 == 3).
//
//        Add new ArrayList<>(inner) to outer.
//
//        outer is now [[1, 2, 2], [1, 2], [1], [2, 2]].
//
//        add
//
//        Backtrack: inner removes 2, becomes [2].
//
//        \ exclude dup2 Branch: (This is the second call from (2, [2]))
//
//        Duplicate skip logic for arr[2] (2).
//
//        nextUniqueIndex starts at index + 1 = 3. Loop condition nextUniqueIndex < arr.length is false.
//
//        nextUniqueIndex remains 3.
//
//        Recursive call: subsets(arr, 3, [2], outer) (Node: (3, [2]))
//
//        Base Case: index == arr.length (3 == 3).
//
//        Add new ArrayList<>(inner) to outer.
//
//        outer is now [[1, 2, 2], [1, 2], [1], [2, 2], [2]].
//
//        add
//
//        Backtrack: inner removes 2, becomes [].
//
//        \ EXCLUDE 2 Branch: (This is the second call from (1, []))
//
//        Duplicate skip logic for arr[1] (2).
//
//        nextUniqueIndex starts at index + 1 = 2.
//
//        arr[2] is 2, which is equal to arr[1]. So nextUniqueIndex becomes 3.
//
//        nextUniqueIndex = 3 is not less than arr.length. Loop ends.
//
//        nextUniqueIndex is now 3.
//
//        Recursive call: subsets(arr, 3, [], outer) (Node: (3, []))
//
//        Base Case: index == arr.length (3 == 3).
//
//        Add new ArrayList<>(inner) to outer.
//
//        outer is now [[1, 2, 2], [1, 2], [1], [2, 2], [2], []].
//
//        add
//
//        Backtrack: inner remains [].
//
//        Final outer list: [ [1, 2, 2], [1, 2], [1], [2, 2], [2], [] ]







//    Why Skip Duplicates ONLY in the EXCLUDE Branch?The core reason is to prevent redundant generation of the same subset.The INCLUDE Branch is Essential: The INCLUDE branch must always be executed for the current element (arr[index]), regardless of whether it's a duplicate or not.Example: For $\{1, 2, 2\}$, if you are at the first '2' (index 1), including it ([..., 2]) and then continuing the recursion is the only way to find the subset $\{1, 2, 2\}$. If you skipped the include, you'd miss the $\{1, 2, 2\}$ subset.The EXCLUDE Branch is the Redundancy Filter: When you choose to EXCLUDE the current element (arr[index]), you are essentially saying: "I am deciding not to use this number for the current subset I'm building."If you then let the recursion continue to the next identical duplicate (e.g., the second '2'), that next duplicate will also have an INCLUDE branch.The subset created by EXCLUDING the first '2' and INCLUDING the second '2' is identical to the subset created by just INCLUDING the first '2'.Subset GoalAction at First '2' (Index 1)Action at Second '2' (Index 2)Resulting SubsetRedundancy?$\{1, 2\}$INCLUDEEXCLUDE$\{1, 2\}$Unique$\{1, 2\}$EXCLUDE (skip)Jumps to end$\rightarrow$ MissedNo, we fix this:$\{1, 2\}$EXCLUDE (skip to index 3)$\rightarrow$ Done$\{1\}$Yes!$\rightarrow$ $\{1, 2\}$EXCLUDE (skip)$\rightarrow$ We must use the first line's result to get $\{1, 2\}$The logic is simpler: Any subset you can form by EXCLUDING the first '2' and INCLUDING a later '2' is already covered by INCLUDING the first '2' and continuing the recursion.Therefore, in the EXCLUDE branch, we must skip all identical neighbors to prevent generating the same subsets again through a different, redundant path.



//    If arr = [1, 2, 2]:
//
//        At index 1 → value is 2
//
//        At index 2 → value is also 2
//
//        If you EXCLUDE arr[1], and then again EXCLUDE arr[2],
//        you get the same subset twice.
//
//        The logic:
//
//        while values ahead are equal to current value
//        skip those indices
//
//
//        This effectively jumps over all duplicates:
//
//        index = 1 (value = 2)
//        nextUniqueIndex moves → 2 → 3
//
//
//        Then you call recursion on index 3.
//
//        This avoids duplicate subsets or duplicate recursion paths.