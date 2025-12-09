package com.anil.src;

import java.util.ArrayList;

//this acc method is cleaner than the return type one.
//inner is the acc
public class SubsetsRecursive {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        subsets(arr, 0, new ArrayList<Integer>(),ans);
        System.out.println(ans);
    }

    //learn with the rec tree u will get it
    private static void subsets(int[] arr, int index, ArrayList<Integer> inner, ArrayList<ArrayList<Integer>> outer) {

        if (index == arr.length){
            outer.add(new ArrayList<>(inner));
            return;
        }
        //add element
        inner.add(arr[index]);

        //move to next element
        subsets(arr,index + 1,inner,outer);

        //backtrack
        inner.remove(inner.size() - 1);

        subsets(arr,index + 1,inner,outer);
    }
}





//    We don’t add subsets in the middle.
//        We add subsets only after we have made choices for all elements.
//
//        So the recursion walks down the tree, and when a full path is decided, it records one subset.
//
//                 []
//              /       \
//        [1]                []
//        /   \            /     \
//        [1,2] [1]        [2]     []
//        /   \       /  \       /  \         /   \
//        [1,2,3] [1,2] [1,3] [1] [2,3] [2]     [3]     []
//
//
//        Input:
//
//        arr = [1,2,3]
//
//        Start:
//        index=0, inner=[], outer=[]
//
//        1. INCLUDE 1
//        inner = [1]
//
//        Go deeper (index=1)
//        1A. INCLUDE 2
//        inner = [1,2]
//
//        Go deeper (index=2)
//        1A(i). INCLUDE 3
//        inner = [1,2,3]
//        index = 3 → base case → add [1,2,3]
//
//
//        Backtrack:
//
//        inner = [1,2]
//
//        1A(ii). EXCLUDE 3
//        inner = [1,2]
//        index = 3 → add [1,2]
//
//
//        Backtrack to:
//
//        inner = [1]
//
//        1B. EXCLUDE 2
//        inner = [1]
//
//        Go deeper (index=2)
//        1B(i). INCLUDE 3
//        inner = [1,3]
//        index=3 → add [1,3]
//
//
//        Backtrack:
//
//        inner = [1]
//
//        1B(ii). EXCLUDE 3
//        inner = [1]
//        index=3 → add [1]
//
//
//        Backtrack fully:
//
//        inner = []
//
//        Up to now, outer =
//        [ [1,2,3], [1,2], [1,3], [1] ]
//
//        2. EXCLUDE 1
//        inner = []
//
//        Go deeper (index=1)
//        2A. INCLUDE 2
//        inner=[2]
//
//        index=2:
//        2A(i). INCLUDE 3
//
//        add [2,3]
//
//        Backtrack → inner=[2]
//
//        2A(ii). EXCLUDE 3
//
//        add [2]
//
//        Backtrack → inner=[]
//
//        2B. EXCLUDE 2
//
//        inner = []
//
//        index=2:
//        2B(i). INCLUDE 3
//
//        add [3]
//
//        Backtrack → inner=[]
//
//        2B(ii). EXCLUDE 3
//
//        add []



//        🧐 Why the index Stays the Same (and Why It Should)
//        1. The Call Stack Saves index
//        When the function subsets is called, a new stack frame is created. This stack frame holds the value of index for that specific level of the recursion.
//
//        When you are at index=2 (considering element 3):
//
//        The stack frame for index=2 is active.
//
//        You call subsets(arr, 3, ...) (the INCLUDE 3 branch).
//
//        The call to index=3 hits the base case and returns.
//
//        Control returns to the same stack frame where index is still 2. It never decreases.
//
//        2. The index is a Decision Tracker
//        The index variable represents which element you are currently making a decision about.
//
//        Let's look at the part of the trace you asked about:
//
//        At index = 2 (Decision for element 3):
//        INCLUDE 3:
//
//        inner becomes [1, 2, 3].
//
//        Call subsets(arr, index=3, inner=[1, 2, 3], outer)
//
//        This hits the base case and returns. outer adds [1, 2, 3].
//
//        Control returns to the main function body at index=2.
//
//        BACKTRACK (The Undo):
//
//        inner.remove(inner.size() - 1);
//
//        inner returns to [1, 2].
//
//        EXCLUDE 3:
//
//        Control is still in the function frame where index is 2.
//
//        You call subsets(arr, index + 1, inner=[1, 2], outer)
//
//        Call subsets(arr, index=3, inner=[1, 2], outer)
//
//        This hits the base case and returns. outer adds [1, 2].
