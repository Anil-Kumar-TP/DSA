package src.com.anil;

public class Shadowing {
    static int x = 90;
    public static void main(String[] args) {
        System.out.println(x);
        int x = 40;
        System.out.println(x);//higher level scopes are blocked in lower level,so 40.
        print();
    }

    private static void print() {
        System.out.println(x);
    }
}
