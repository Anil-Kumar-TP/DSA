package com.anil.src;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElement1Optimal {
    public static void main(String[] args) {
        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};
        int[] ans = nextGreaterElement(nums1,nums2);
        System.out.println(Arrays.toString(ans));
    }

    private static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        for (int num : nums2){
            while (!stack.isEmpty() && num > stack.peek()){
                map.put(stack.pop(),num);
            }
            stack.push(num);
        }

        while (!stack.isEmpty()){
            map.put(stack.pop(),-1);
        }

        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++){
            result[i] = map.get(nums1[i]);
        }

        return result;
    }
}


//
//Imagine you are at a crowded event. There is a Waiting Room (the Stack).
//
//If you enter the room, you sit at the very front.
//
//You can only leave the room if someone taller than you arrives at the door.
//
//When a taller person arrives, they "rescue" everyone in the room who is shorter than them.
//
//        Let's trace nums2 = [1, 3, 4, 2]:
//
//Person "1" arrives: The room is empty. 1 goes in and sits down.
//
//        Room: [1]
//
//Person "3" arrives: 3 looks at the room. Is 3 taller than 1? Yes!
//
//        3 rescues 1. We write down: "Next greater for 1 is 3" (Store in Map).
//
//Now the room is empty, so 3 sits down to wait.
//
//Room: [3]
//
//Person "4" arrives: 4 looks at the room. Is 4 taller than 3? Yes!
//
//        4 rescues 3. We write down: "Next greater for 3 is 4" (Store in Map).
//
//Now the room is empty, so 4 sits down to wait.
//
//Room: [4]
//
//Person "2" arrives: 2 looks at the room. Is 2 taller than 4? No.
//
//2 can't rescue anyone. 2 goes into the room and sits behind 4.
//
//Room: [4, 2]
//
//End of the line: The event is over. 4 and 2 are still in the room. No one ever rescued them.