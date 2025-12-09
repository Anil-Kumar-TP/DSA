package MemoryManagement.Primitive;

public class PrimitivePassByValue {
    public static void main(String[] args) {
        int original = 10;  // Primitive variable holding value 10
        System.out.println("Before method: " + original);  // Outputs: 10

        changePrimitive(original);  // Pass a COPY of 10

        System.out.println("After method: " + original);  // Still 10! Original unchanged
    }

    public static void changePrimitive(int copy) {
        copy = 20;  // This changes the copy, not the original
        System.out.println("Inside method: " + copy);  // Outputs: 20
    }
}


//    original holds 10 in memory (let's say at some stack location).
//        When you call changePrimitive(original), Java copies 10 into a new variable copy inside the method.
//        Changing copy to 20? That's like scribbling on a photocopy—the original document (your original variable) stays the same.
//        Same for double: If you pass double pi = 3.14;, the method gets a copy of 3.14.


    //application


//    Key Takeaway for DSA: In algorithms, if you're passing primitives (e.g., an int counter in a loop), don't expect changes inside a helper method to update the caller's variable. You'd need to return the new value instead.

//public class Main {
//    public static void increment(int x) {
//        x = x + 1; // only changes local copy
//    }
//
//    public static void main(String[] args) {
//        int count = 5;
//        increment(count);
//        System.out.println(count); // still 5 ❌
//    }
//}



//    public static int increment(int x) {
//        return x + 1;
//    }
//
//    public static void main(String[] args) {
//        int count = 5;
//        count = increment(count); // reassign
//        System.out.println(count); // 6 ✅
//    }



