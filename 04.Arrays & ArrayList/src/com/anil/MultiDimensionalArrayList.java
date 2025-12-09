package src.com.anil;

import java.util.ArrayList;
import java.util.Scanner;

public class MultiDimensionalArrayList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < 3; i++){
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                list.get(i).add(sc.nextInt());
            }
        }
        System.out.println(list);

//        for (int i = 0; i < list.size(); i++) {              // loop through rows
//            for (int j = 0; j < list.get(i).size(); j++) {   // loop through columns
//                System.out.print(list.get(i).get(j) + " ");
//            }
//            System.out.println();  // new line after each row
//        }

    }
}
