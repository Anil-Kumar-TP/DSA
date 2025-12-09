package src.com.anil;

public class EvenDigits {
    public static void main(String[] args) {
        int[] nums = {12,345,2,6,7896,-32};
        int ans = even(nums);
        System.out.println(ans);
    }

    private static int even(int[] nums) {
        int count = 0;
        for (int num : nums){
            if (evenDigits(num)){
                count++;
            }
        }
        return count;
    }

    private static boolean evenDigits(int num) {
        int numberOfDigits = digitCount(num);
        if (numberOfDigits % 2 == 0){
            return true;
        }
        return false;
    }

    private static int digitCount(int num) {
        if (num < 0){
            num = num * -1;
        }
        return (int)(Math.log10(num)) + 1;
    }
}
