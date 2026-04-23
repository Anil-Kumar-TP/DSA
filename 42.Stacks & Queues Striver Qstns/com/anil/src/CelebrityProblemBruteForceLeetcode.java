package com.anil.src;

public class CelebrityProblemBruteForceLeetcode {

    public int findCelebrity(int n){
        for (int i = 0; i < n; i++){
            boolean isCelebrity = true;
            for (int j = 0; j < n; j++){
                if (i == j) {
                    continue;
                }

                if (knows(i,j)){
                    isCelebrity = false;
                    break;
                }

                if (!knows(j,i)){
                    isCelebrity = false;
                    break;
                }
            }

            if (isCelebrity){
                return i;
            }
        }

        return -1;
    }

    boolean knows(int a, int b) {
        return false;
    }
}
