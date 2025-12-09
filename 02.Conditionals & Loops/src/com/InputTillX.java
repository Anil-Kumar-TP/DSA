package src.com;

import java.util.Scanner;

public class InputTillX {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true){
            String input = sc.nextLine();
            if (input.equalsIgnoreCase("x")){
                break;
            }
            System.out.println("You entered : " + input);
        }
        sc.close();
    }
}
