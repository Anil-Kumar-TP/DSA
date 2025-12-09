package com.anil.src;

import java.util.*;

public class PermutationArraysWithDuplicateSwap {
    public static void main(String[] args) {
        int[] arr = {1,2,2};
        List<List<Integer>> ans = new ArrayList<>();
        permutation(arr,0,ans);
        System.out.println(ans);
    }

    private static void permutation(int[] arr, int start, List<List<Integer>> ans) {
        if (start == arr.length) {
            ans.add(new ArrayList<>(Arrays.stream(arr).boxed().toList()));
            return;
        }

        Set<Integer> used = new HashSet<>();

        for (int i = start; i < arr.length; i++) {

            if (used.contains(arr[i])) continue;
            used.add(arr[i]);

            swap(arr, start, i);
            permutation(arr, start + 1, ans);
            swap(arr, start, i);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

//        The reason we can use the simple ans.add(new String(arr)) for characters is due to a specific, helpful, built-in constructor in the Java String class that doesn't exist for the ArrayList class.
//
//        🧐 The Exception: The String Constructor
//        The key difference lies in what the constructor is expecting:
//
//        Data Type	Constructor Used	Why it Works	Why it's Simple
//        Character Array (char[] arr)	new String(char[] value)	Java's String class has a constructor explicitly designed to accept a primitive array of characters (char[]) and perform the O(N) deep copy internally.	It's a single, dedicated constructor designed for this exact conversion.
//        Integer Array (int[] nums)	new ArrayList<>(...)	ArrayList constructors only accept other Collection objects (like other Lists, Sets, etc.), not primitive arrays (int[]).	No such single, dedicated constructor exists for ArrayList to accept int[].
//
//
//        The Trace: What Happens in Memory
//        String Case:
//
//        ‘ans.add(new String(arr));‘
//        The String object sees the char[] arr, allocates space for the new string, and then copies all the characters from the array into its own memory space. You get your O(N) deep copy for free in one line.
//
//        Integer Array Case:
//
//        ‘ans.add(new ArrayList<>(nums));‘
//        The compiler sees an int[] being passed to an ArrayList constructor that expects a Collection. It sees a type mismatch and fails to compile, forcing you to manually wrap the primitive int values into Integer objects (using streams and .boxed()) before it can collect them into the ArrayList.
//
//        The bottom line is: String is a special case in Java with many convenient constructors for conversion. ArrayList is a generic class that must adhere strictly to the rules of Collection types.