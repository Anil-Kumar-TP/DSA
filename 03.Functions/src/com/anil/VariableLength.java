package src.com.anil;

import java.util.Arrays;

public class VariableLength {
    public static void main(String[] args) {
        multiple(20,30,"Anil","Achu");
    }

    private static void multiple(int num1, int num2, String ...v) {
        System.out.println(Arrays.toString(v));
    }
}
