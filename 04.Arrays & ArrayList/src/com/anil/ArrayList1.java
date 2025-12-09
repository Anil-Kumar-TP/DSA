package src.com.anil;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayList1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>(5);
        for (int i = 0; i <= 5; i++){
            list.add(sc.nextInt());
        }
//        System.out.println(list);

        for (int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }
    }
}
