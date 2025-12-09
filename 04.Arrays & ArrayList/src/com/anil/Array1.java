package src.com.anil;

import java.util.Arrays;
import java.util.Scanner;

public class Array1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[5];
        for (int i = 0; i < arr.length; i++){
            System.out.println("Enter the " + i + " number");
            arr[i] = sc.nextInt();
        }
        System.out.println(Arrays.toString(arr));
    }
}
