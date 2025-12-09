package src.com.anil;

public class KthMissingPositiveNumberBruteForce {
    public static void main(String[] args) {
        int[] arr = {4,7,9,10};
        int k = 4;
        int ans = missing(arr,k);
        System.out.println(ans);
    }

    private static int missing(int[] arr, int k) {
        for (int i = 0; i < arr.length; i++){
            if (arr[i] <= k){
                k++;
            }else {
                break;
            }
        }
        return k;
    }
}

//connect it to this
//so the numbers present in the array act as the occupied seats?
//so the man at the counter says ur seat is the 5th empty one in the F corner,
//so I reach the F corner starts counting empty seats
//1st one is occupied, so it would not be the 5th one from the start of that row not straightforward,
//so I see the second seat is empty
//even though it is the second seat it is the first empty one i found
//so what should have been 2nd empty seat is actually the 1st so to my surprise my seat which is the 5th in the row now has to shift a little more right>

