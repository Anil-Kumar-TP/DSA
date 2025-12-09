package MemoryManagement.String;

public class Main {
    public static void appendString(String s) {
        s = s + " kumar";  // creates a NEW String object
    }

    public static void main(String[] args) {
        String name = "anil";
        appendString(name);
        System.out.println(name); // still "anil"
    }
}




//public class Main {
//    static String addText(String original) {
//        return original + " kumar"; // creates new string with old + new
//    }
//
//    public static void main(String[] args) {
//        String name = "anil";
//        name = addText(name);
//        System.out.println(name); // "anil kumar" ✅ both preserved
//    }
//}
//Strings can’t be mutated. So if you want to “add” instead of overwrite, you return a new String that combines old + new.

