package com.anil.src;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class AstroidCollision {
    public static void main(String[] args) {
        int[] astroids = {3,5,-6,2,-1,4};
        int[] ans = astroidCollision(astroids);
        System.out.println(Arrays.toString(ans));
    }

    private static int[] astroidCollision(int[] astroids) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (int astroid : astroids){
            if (astroid > 0){
                stack.addLast(astroid);
                continue;
            }

            while (!stack.isEmpty() && stack.peekLast() > 0 && stack.peekLast() < -astroid){
                stack.pollLast();
            }

            //imp -- this shouldn't be a while loop or else it would destroy others that needn't
            //ex:[5,5,-5]
            //result should be [5].
            //if we use while loop the -5 would destroy both positive 5 which we don't want
            if (!stack.isEmpty() && stack.peekLast() == -astroid){
                stack.pollLast();
            }else if (stack.isEmpty() || stack.peekLast() < 0){
                stack.addLast(astroid);
            }
        }

        int[] result = new int[stack.size()];
        int i = 0;
        for (int val : stack){
            result[i++] = val;
        }

        return result;
    }
}

//reason for deque instead of stack
//When the collisions are over, the problem asks you to return the surviving asteroids in their original left-to-right order.
//If you use a traditional Stack (or a Deque as a stack):The Stack order is Top-to-Bottom: [Right-most, ..., Left-most].The Required order is Left-to-Right: [Left-most, ..., Right-most].Because a Deque is a "Double-Ended Queue," it maintains an internal pointer to the Front (the first asteroid added / the left-most) and the Back (the last asteroid added / the right-most).When you use a for-each loop on a Deque, it automatically iterates from First to Last.Java// This loop starts at the "Bottom" of the stack (the left-most asteroid)
//// and moves to the "Top" (the right-most).
//for (int val : stack) {
//result[i++] = val;
//}
//If you were strictly limited to "Stack" operations (pop), you would have to pop everything out into an array and then reverse the entire array to get the correct order. The Deque lets you skip that extra $O(N)$ step entirely