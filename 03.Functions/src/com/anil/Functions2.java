package src.com.anil;

import java.util.Scanner;

public class Functions2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name");
        String name = sc.next();
        String greeting = greet(name);
        System.out.println(greeting);
    }

    private static String greet(String name) {
        return "Greeting " + name;
    }
}
