package src.com.anil;

import java.util.Scanner;

public class CheckArmstrong {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean ans = isArmstrong(n);
        System.out.println(ans);
    }

    private static boolean isArmstrong(int n) {
        int originalNumber = n;
        int sum = 0;
        while (n > 0){
            int rem = n % 10;
            int cube = rem * rem * rem;
            sum = sum + cube;
            n = n / 10;
        }
        return originalNumber == sum;
    }
}
