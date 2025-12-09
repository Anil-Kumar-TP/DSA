package com.anil.src;

public class Steps {
    public static void main(String[] args) {
        int num = 14;
        int ans = steps(num,0);
        System.out.println(ans);
    }

    private static int steps(int num, int stepsTaken) {
        if (num == 0){
            return stepsTaken;
        }
        if (num % 2 == 0){
            return steps(num / 2,stepsTaken + 1);
        }else {
            return steps(num - 1,stepsTaken + 1);
        }
    }
}
