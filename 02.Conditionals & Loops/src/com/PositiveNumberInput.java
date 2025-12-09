package src.com;

import java.util.Scanner;

public class PositiveNumberInput {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true){
            int n = sc.nextInt();
            if (n > 0){
                System.out.println("Exiting as it is positive");
                break;
            }else {
                System.out.println("keep entering");
            }
        }
        sc.close();
        System.out.println("Program ended");

    }
}
