package com.anil.src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeOverlappingIntervalsOptimal {
    public static void main(String[] args) {
        int[][] arr = {
                {1,3},
                {2,6},
                {8,9},
                {9,11},
                {8,10},
                {2,4},
                {15,18},
                {16,17}
        };
        int[][] ans = merge(arr);
        System.out.println(Arrays.deepToString(ans));
    }

    private static int[][] merge(int[][] arr) {

        if (arr.length <= 1){
            return arr;
        }

        Arrays.sort(arr,(a,b)->Integer.compare(a[0],b[0]));

        List<int[]> merged = new ArrayList<>();

        merged.add(arr[0]);

        for (int i = 1; i < arr.length; i++){
            int[] curr = arr[i];
            int[] last = merged.getLast();

            if (curr[0] <= last[1]){//overlap or touching
                last[1] = Math.max(last[1],curr[1]);//extend end.
            }else{
                merged.add(curr);//no overlap.new interval.
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }
}


//Input: [[1,3], [2,6], [8,10]] (already sorted)
//
//Init: merged = [[1,3]].$i = 1$
//        (curr = [2,6]):last = [1,3].
//        2 <= 3? YES.
//        last[1] = max(3, 6) = 6.
//merged is now [[1,6]].
//$i = 2$
//        (curr = [8,10]):last = [1,6].
//        8 <= 6? NO.
//        merged.add([8,10]).
//merged is now [[1,6], [8,10]].
//Result: [[1,6], [8,10]].



//An interval is a pair of numbers (start and end).
//
//An int[] is a container that can hold both.
//
//An Integer is just one single number.
//
//If you used ArrayList<Integer>, you would have a flat list like [1, 6, 8, 10, 15, 18]. You would lose the "pairing" that tells you 1 and 6 belong together as one interval.
//By using ArrayList<int[]>, you are creating a List of Pairs.