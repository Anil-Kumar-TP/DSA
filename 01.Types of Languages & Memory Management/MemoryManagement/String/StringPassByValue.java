package MemoryManagement.String;

public class StringPassByValue {
    public static void main(String[] args) {
        String original = "hello";  // Reference to "hello" object
        System.out.println("Before method: " + original);  // Outputs: hello

        changeString(original);  // Pass a COPY of the reference

        System.out.println("After method: " + original);  // Still hello! Original reference unchanged
    }

    public static void changeString(String copyRef) {
        // Try to "modify" – this creates a NEW string and updates the copy reference
        copyRef = copyRef.toUpperCase();  // copyRef now points to "HELLO" (new object)
        System.out.println("Inside method: " + copyRef);  // Outputs: HELLO

        // Or even reassign: copyRef = "world";  // copyRef points to yet another new object
    }
}


//    original is a reference variable pointing to the "hello" object in heap memory.
//        Passing to changeString(original): Java copies the reference into copyRef. Now both point to the same "hello" object.
//        Inside the method:
//
//        copyRef.toUpperCase() doesn't change the existing "hello" (immutability!). It creates a new "HELLO" object and makes copyRef point to it.
//        Or if you do copyRef = "world";, copyRef now points to a new object, but original still points to "hello".
//
//
//        Back in main(), original is untouched—its reference hasn't changed.
//        If String weren't immutable, you could mutate the shared object (like with arrays or custom objects), but strings prevent that.

