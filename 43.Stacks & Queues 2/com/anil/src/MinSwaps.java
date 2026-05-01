package com.anil.src;

import java.util.Stack;

public class MinSwaps {
    public static void main(String[] args) {
        String str = "]]][[[";
        int ans = minSwaps(str);
        System.out.println(ans);
    }

    private static int minSwaps(String str) {
        Stack<Character> stack = new Stack<>();

        for (char ch : str.toCharArray()){
            if (ch == '['){
                stack.push(ch);
            }else {
                if (!stack.isEmpty() && stack.peek() == '['){
                    stack.pop();
                }
            }
        }

        return (stack.size() + 1 ) / 2;
    }
}



/*
========================================
Minimum Swaps to Balance Brackets
========================================

Input:
s = "[]]][["   (Length = 6)

----------------------------------------
Step-by-Step Trace
----------------------------------------

Step | Char | Action        | Stack Content | Explanation
--------------------------------------------------------
1    |  [   | Push          | [             | Found an opening bracket
2    |  ]   | Pop           | empty         | Matched with '['
3    |  ]   | Ignore        | empty         | No matching '[', this is "debt"
4    |  ]   | Ignore        | empty         | More unmatched closing brackets
5    |  [   | Push          | [             | New opening bracket
6    |  [   | Push          | [ [           | Another opening bracket

----------------------------------------
After Traversal
----------------------------------------

Stack size (N) = 2

Stack contains:
    [ [

These are unmatched opening brackets.

Note:
Even though we ignored unmatched ']' earlier,
since total '[' == total ']',
those missing closers must exist implicitly.

So the problematic part is effectively:
    ] ] [ [

----------------------------------------
Formula
----------------------------------------

Minimum swaps needed:
    swaps = (N + 1) / 2

Where:
    N = number of unmatched '[' in stack

----------------------------------------
Calculation
----------------------------------------

swaps = (2 + 1) / 2
      = 3 / 2
      = 1   (integer division)

----------------------------------------
Final Answer
----------------------------------------

Minimum swaps = 1

----------------------------------------
Key Intuition
----------------------------------------

- Stack tracks unmatched '['
- Unmatched ']' are ignored but implicitly counted
- Each swap fixes TWO mismatches
- Hence division by 2

========================================
*/
