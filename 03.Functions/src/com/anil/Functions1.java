package src.com.anil;

import java.util.Scanner;

public class Functions1 {
    public static void main(String[] args) {
        sum();
        int result = sum2();
        System.out.println("Result is " + result);
        int ans = sum3(30,45);
        System.out.println(ans);
    }

    private static int sum3(int num1, int num2) {
        return num1 + num2;
    }

    private static int sum2() {
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        return num1 + num2;
    }

    private static void sum() {
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int ans = num1 + num2;
        System.out.println("Sum of the numbers is " + ans);
    }
}
