package com.anil.src;

public class PermutationStrings {
    public static void main(String[] args) {
        permutation("","abc");
    }

    private static void permutation(String finalOne, String initialOne) {
        if (initialOne.isEmpty()){
            System.out.println(finalOne);
            return;
        }
        char ch = initialOne.charAt(0);

        for (int i = 0; i <= finalOne.length(); i++){
            String first = finalOne.substring(0,i);
            String second = finalOne.substring(i,finalOne.length());

            permutation(first + ch + second,initialOne.substring(1));
        }
    }
}


//
//    We start with:
//
//        permutation("", "abc")
//
//        🎬 CALL 1
//        permutation("", "abc")
//        finalOne = ""
//        initialOne = "abc"
//        ch = 'a'
//        i runs from 0 to 0
//
//        i = 0:
//        first  = ""
//        second = ""
//        → "a"
//
//
//        So next call:
//
//        🎬 CALL 2
//        permutation("a", "bc")
//        finalOne = "a"
//        initialOne = "bc"
//        ch = 'b'
//        i runs from 0 to 1
//
//        🔹 i = 0 in CALL 2
//        first  = ""
//        second = "a"
//        → "ba"
//
//
//        Next call:
//
//        🎬 CALL 3
//        permutation("ba", "c")
//        finalOne = "ba"
//        initialOne = "c"
//        ch = 'c'
//        i runs from 0 to 2
//
//        🔸 i = 0 in CALL 3
//        first  = ""
//        second = "ba"
//        → "cba"
//
//
//        Next call:
//
//        🎬 CALL 4
//        permutation("cba", "")
//        initialOne is empty → PRINT "cba"
//        RETURN
//
//
//        Back to CALL 3.
//
//        🔸 i = 1 in CALL 3
//        first  = "b"
//        second = "a"
//        → "bca"
//
//
//        Next call:
//
//        🎬 CALL 5
//        permutation("bca", "")
//        PRINT "bca"
//        RETURN
//
//
//        Back to CALL 3.
//
//        🔸 i = 2 in CALL 3
//        first  = "ba"
//        second = ""
//        → "bac"
//
//
//        Next call:
//
//        🎬 CALL 6
//        permutation("bac", "")
//        PRINT "bac"
//        RETURN
//
//
//        CALL 3 is finished.
//        Return to CALL 2.
//
//        ⭐ Up to this point, ONLY "ba" branch is done.
//
//        Now CALL 2 continues…
//
//        🔹 i = 1 in CALL 2
//        first  = "a"
//        second = ""
//        → "ab"
//
//
//        Next call:
//
//        🎬 CALL 7
//        permutation("ab", "c")
//        finalOne = "ab"
//        initialOne = "c"
//        ch = 'c'
//        i runs 0 to 2
//
//        🔸 i = 0 in CALL 7
//        first  = ""
//        second = "ab"
//        → "cab"
//
//
//        Next call:
//
//        🎬 CALL 8
//        permutation("cab", "")
//        PRINT "cab"
//        RETURN
//
//
//        Back to CALL 7.
//
//        🔸 i = 1 in CALL 7
//        first  = "a"
//        second = "b"
//        → "acb"
//
//
//        Next call:
//
//        🎬 CALL 9
//        permutation("acb", "")
//        PRINT "acb"
//        RETURN
//
//
//        Back to CALL 7.
//
//        🔸 i = 2 in CALL 7
//        first  = "ab"
//        second = ""
//        → "abc"
//
//
//        Next call:
//
//        🎬 CALL 10
//        permutation("abc", "")
//        PRINT "abc"
//        RETURN
//
//
//        CALL 7 ends.
//        CALL 2 ends.
//        CALL 1 ends.
//
//        ✅ FINAL PRINT ORDER (exact program output)
//        cba
//        bca
//        bac
//        cab
//        acb
//        abc