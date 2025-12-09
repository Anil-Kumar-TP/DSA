package com.anil.src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsIterativeDuplicates {
    public static void main(String[] args) {
        int[] arr = {1,2,2};
        List<List<Integer>> ans = subset(arr);
        System.out.println(ans);
    }

    private static List<List<Integer>> subset(int[] arr) {
        Arrays.sort(arr);

        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());

        int startIndex = 0;
        int endIndex = 0;// Represents the start index of new subsets to be created

        for (int i = 0; i < arr.length; i++){
            // Check for duplicates
            if (i > 0 && arr[i] == arr[i - 1]){
                // If it's a duplicate, we only want to add it to the subsets
                // that were created in the *previous* iteration.
                // 'startIndex' becomes the old 'endIndex' + 1.
                startIndex = endIndex + 1;
            }else {
                // If it's a new unique number, we expand ALL existing subsets.
                startIndex = 0;
            }

            endIndex = outer.size() - 1;

            int currentSize = outer.size();

            // 3. Expansion Loop: Start from 'startIndex'
            // This is the core modification to skip copying subsets that already exist.
            for (int j = startIndex; j < currentSize; j++) {

                // Copy the existing subset
                List<Integer> existingSubset = outer.get(j);
                List<Integer> newSubset = new ArrayList<>(existingSubset);

                // Add the current number
                newSubset.add(arr[i]);

                // Add to the result
                outer.add(newSubset);
            }
        }
        return outer;
    }
}

//for subseq iterative it will be complex
//so for subseq stick with rec solution.


//
//Variable,Initial Value,Notes
//        arr,"{1, 2, 2}",Input array (sorted)
//        outer,[[]],Initial result list (contains the empty set)
//        startIndex,0,Index in outer to start the expansion from
//        endIndex,0,Index that will track the boundary of new subsets from the previous step
//
//        Step,Code Logic,Variable State Update,outer
//        Check Dup,i > 0 is false.,startIndex remains 0.,[[]]
//        Assign endIndex,endIndex = outer.size() - 1,endIndex becomes 0.,[[]]
//        Assign currentSize,currentSize = outer.size(),currentSize becomes 1.,[[]]
//        Expansion Loop,for (j = 0; j < 1) (Runs once for j=0),,
//        j=0,existingSubset = outer.get(0) → [],newSubset = [1]. outer adds [1].,"[[], [1]]"
//        End of Loop,,,
//        Final State,,"startIndex=0,endIndex=0","[[],[1]]"
//
//
//        Step,Code Logic,Variable State Update,outer
//        Check Dup,arr[1] != arr[0] (2 != 1). Unique.,startIndex remains 0.,"[[], [1]]"
//        Assign endIndex,endIndex = outer.size() - 1,endIndex becomes 1.,"[[], [1]]"
//        Assign currentSize,currentSize = outer.size(),currentSize becomes 2.,"[[], [1]]"
//        Expansion Loop,"for (j = 0; j < 2) (Runs for j=0,1)",,
//        j=0,existingSubset = outer.get(0) → [],newSubset = [2]. outer adds [2].,"[[], [1], [2]]"
//        j=1,existingSubset = outer.get(1) → [1],"newSubset = [1, 2]. outer adds [1, 2].","[[], [1], [2], [1, 2]]"
//        End of Loop,,,
//        Final State,,"startIndex=0,endIndex=1","[[],[1],[2],[1,2]]"
//
//        Step,Code Logic,Variable State Update,outer
//        Check Dup,arr[2] == arr[1] (2 == 2). Duplicate.,"Crucial: startIndex = endIndex + 1.  Since endIndex from the previous iteration was 1, startIndex becomes 2.","[[], [1], [2], [1, 2]]"
//        Assign endIndex,endIndex = outer.size() - 1,endIndex becomes 3.,"[[], [1], [2], [1, 2]]"
//        Assign currentSize,currentSize = outer.size(),currentSize becomes 4.,"[[], [1], [2], [1, 2]]"
//        Expansion Loop,"for (j = 2; j < 4) (Runs for j=2,3)",,
//        j=2,existingSubset = outer.get(2) → [2],"newSubset = [2, 2]. outer adds [2, 2].","[...], [2, 2]"
//        j=3,"existingSubset = outer.get(3) → [1, 2]","newSubset = [1, 2, 2]. outer adds [1, 2, 2].","[...], [2, 2], [1, 2, 2]"
//        End of Loop,,,
//        Final State,,"startIndex=4,endIndex=3","[[],[1],[2],[1,2],[2,2],[1,2,2]]"