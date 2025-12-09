package com.anil.src;

public class PermutationStringSwap {
    public static void main(String[] args) {
        String str = "abc";
        char[] chars = str.toCharArray();
        permutation(chars,0);
    }

    private static void permutation(char[] arr, int start) {
        // 1. Base Case: If the start index reaches the end, a permutation is complete.
        if (start == arr.length - 1){
            System.out.println(new String(arr));
            return;
        }
        // 2. Loop: Try placing every remaining character (from index 'start' to 'end')
        //    at the current 'start' position.
        for (int i = start; i < arr.length; i++){
            // 2a. Action: Swap current position (start) with the element at i
            swap(arr,start,i);
            // 2b. Recurse: Fix the current position and solve the rest of the array (start + 1)
            permutation(arr,start + 1);
            // 2c. Backtrack: Swap them back to restore the array state for the next iteration (i+1)
            swap(arr,start,i);
        }
    }

    private static void swap(char[] arr, int first, int second) {
        char temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}

//
//    Call C1: permutation([a b c], start = 0)
//        textCurrent array: [a b c]
//        start = 0
//        Base case? 0 == 2 ? → No, so continue.
//        Enter for (i = start; i <= 2; i++) → i = 0,1,2
//
//        ITERATION C1.i=0
//
//        Computer: “i = 0. I will try element at index 0 in position 0.”
//        Action: swap(0,0) → array becomes [a b c] (no visible change)
//        Computer: “I chose that; now I recurse deeper with start = 1.”
//
//        Call C2: permutation([a b c], start = 1)
//        textCurrent array: [a b c]
//        start = 1
//        Base case? 1 == 2 ? → No, so continue.
//        Enter for (i = 1; i <= 2; i++) → i = 1,2
//
//        C2.i=1
//
//        Computer: “i = 1. I will try element at index 1 in position 1.”
//        Action: swap(1,1) → array [a b c] (no visible change)
//        Computer: “Now recurse deeper with start = 2.”
//
//        Call C3: permutation([a b c], start = 2)
//        textCurrent array: [a b c]
//        start = 2
//        Base case? 2 == 2 ? → Yes.
//        Computer: “Base reached — I will print the permutation as it is now.”
//
//        PRINT: abc
//
//        Computer: “Done printing. Now returning to caller (start = 1).”
//
//        Return from C3 to C2.
//        Back in C2 after recursion: we must undo the choice we made at this level.
//
//        Action: backtrack swap(1,1) → array returns to [a b c]
//        Computer: “Backtracked. Array restored to [a b c]. Continue loop at start = 1.”
//
//        C2.i=2
//
//        Computer: “Now i = 2. I will try element at index 2 in position 1.”
//        Action: swap(1,2) → array becomes [a c b]
//        Computer: “Choice made ([a c b]); recurse deeper with start = 2.”
//
//        Call C4: permutation([a c b], start = 2)
//        textCurrent array: [a c b]
//        start = 2 → Base case reached.
//
//        PRINT: acb
//
//        Computer: “Printed acb. Returning to caller (start = 1).”
//
//        Return from C4 to C2.
//        Back in C2, backtrack action: swap(1,2) → array becomes [a b c] (restored)
//        Computer: “Backtracked to [a b c]. Loop at start = 1 finished (i ended). Returning to caller (start = 0).”
//
//        Back in C1 after C1.i=0 recursion finished.
//        We must backtrack the choice made at start=0 iteration i=0.
//
//        Action: backtrack swap(0,0) → array [a b c] (still same)
//        Computer: “Backtracked swap(0,0), array [a b c]. Now continue loop at start = 0.”
//
//        ITERATION C1.i=1
//
//        Computer: “i = 1. I will try element at index 1 in position 0 (swap 0 and 1).”
//        Action: swap(0,1) → array becomes [b a c]
//        Computer: “Array is now [b a c]. Recurse deeper with start = 1.”
//
//        Call C5: permutation([b a c], start = 1)
//        textCurrent array: [b a c]
//        start = 1 → not base. Loop i = 1..2
//
//        C5.i=1
//
//        Computer: “i = 1. Try element at index 1 in position 1 (swap 1,1).”
//        Action: swap(1,1) → array [b a c] (unchanged)
//        Computer: “Recurse deeper with start = 2.”
//
//        Call C6: permutation([b a c], start = 2)
//        start = 2 → Base case.
//
//        PRINT: bac
//
//        Computer: “Printed bac. Return to caller (start = 1).”
//
//        Return from C6 to C5.
//        Backtrack: swap(1,1) → array [b a c] (restored)
//        Computer: “Backtracked at start = 1 to [b a c]. Continue loop at start = 1.”
//
//        C5.i=2
//
//        Computer: “i = 2. Try element at index 2 in position 1 (swap 1,2).”
//        Action: swap(1,2) → array becomes [b c a]
//        Computer: “Now recurse deeper with start = 2.”
//
//        Call C7: permutation([b c a], start = 2)
//        start = 2 → Base case.
//
//        PRINT: bca
//
//        Computer: “Printed bca. Returning to caller (start = 1).”
//
//        Return from C7 to C5.
//        Backtrack: swap(1,2) → array becomes [b a c] (restored)
//        Computer: “Backtracked to [b a c]. Loop at start = 1 finished. Returning to caller (start = 0).”
//
//        Back in C1 after finishing i=1 branch.
//        Backtrack the earlier choice at start=0:
//
//        Action: swap(0,1) → array becomes [a b c] (restored)
//        Computer: “Backtracked swap(0,1). Array restored to [a b c]. Continue loop at start = 0.”
//
//        ITERATION C1.i=2
//
//        Computer: “i = 2. I will try element at index 2 in position 0 (swap 0,2).”
//        Action: swap(0,2) → array becomes [c b a]
//        Computer: “Array now [c b a]. Recurse deeper with start = 1.”
//
//        Call C8: permutation([c b a], start = 1)
//        start = 1 → Loop i = 1..2
//
//        C8.i=1
//
//        Computer: “i = 1. Try swap(1,1).”
//        Action: swap(1,1) → [c b a]
//        Computer: “Recurse with start = 2.”
//
//        Call C9: permutation([c b a], start = 2)
//        Base case → print.
//
//        PRINT: cba
//
//        Computer: “Printed cba. Returning to caller (start = 1).”
//
//        Return from C9 to C8.
//        Backtrack: swap(1,1) → [c b a]
//        Computer: “Backtracked to [c b a]. Continue loop at start = 1.”
//
//        C8.i=2
//
//        Computer: “i = 2. Try swap(1,2).”
//        Action: swap(1,2) → array becomes [c a b]
//        Computer: “Recurse with start = 2.”
//
//        Call C10: permutation([c a b], start = 2)
//        Base case → print.
//
//        PRINT: cab
//
//        Computer: “Printed cab. Returning to caller (start = 1).”
//
//        Return from C10 to C8.
//        Backtrack: swap(1,2) → array becomes [c b a] (restored)
//        Computer: “Backtracked to [c b a]. Loop at start = 1 finished. Returning to caller (start = 0).”
//
//        Back in C1, final step after i=2 branch done.
//        Backtrack: swap(0,2) → array becomes [a b c] (fully restored)
//        Computer: “Backtracked swap(0,2). Array restored to [a b c]. Loop at start = 0 finished. This call is done.”
//
//        C1 returns to the original caller (end).
//
//        ✅ Final printed permutations in the exact order they were produced (one per base case):
//        abc
//        acb
//        bac
//        bca
//        cba
//        cab