package com.anil.src.innerclass;


public class InnerClass {

    static class Test{
         String name;

        Test(String name){
            this.name = name;
        }
    }


    public static void main(String[] args) {
        Test a = new Test("Anil");
        Test b = new Test("Achu");
        System.out.println(a.name);
        System.out.println(b.name);
    }
}


//if we dont have static on Test it will not compile.
//Every Test object MUST belong to ONE specific InnerClass object.



//public class InnerClass {
//    class Test {   // ← INSIDE another class
//        ...
//    }
//
//    public static void main(String[] args) {
//        Test a = new Test("Anil"); // error
//    }
//}
//
//
//Here:
//
//Test is inside InnerClass
//
//So Test becomes a non-static inner class
//
//Non-static inner class requires an outer object




//class Test { ... }   // ← OUTSIDE
//
//public class InnerClass {
//    public static void main(String[] args) {
//        Test a = new Test("Anil"); // works
//    }
//}
//
//
//Here:
//
//Test is a top-level class
//
//Top-level classes are independent
//
//No outer object required
//
//Behaves like a normal class (like String, Scanner, etc.)















//public class InnerClass {
//
//    static class Test {
//        String name;   // ❌ NOT static
//
//        Test(String name){
//            this.name = name;
//        }
//    }
//
//    public static void main(String[] args) {
//        Test a = new Test("Anil");
//        Test b = new Test("Achu");
//    }
//}

//🔑 Key point
//
//static applies to the CLASS, not to its FIELDS
//
//This means:
//
//Test does not depend on an InnerClass object
//
//But each Test object is still a normal object
//
//Memory picture
//Test object a → name = "Anil"
//Test object b → name = "Achu"
//
//
//Each object has its own instance field.
//
//So output is:
//
//Anil
// Achu




//class Test {
//static String name;   // 🔥 STATIC FIELD
//
//Test(String name){
//    Test.name = name;
//}
//}
//        🔑 Key point
//static on a variable means ONE shared copy for all objects
//
//Memory picture
//text
//Copy code
//Test.name → "Anil"  (after first constructor)
//Test.name → "Achu"  (after second constructor)
//Now both a and b point to the same variable.
//
//So:
//
//java
//Copy code
//System.out.println(a.name); // achu
//System.out.println(b.name); // achu




//public class InnerClass {
//
//    static class Test {
//        static String name;
//
//        Test(String name) {
//            this.name = name;
//        }
//    }
//
//    public static void main(String[] args) {
//        Test a = new Test("Anil");
//        Test b = new Test("Achu");
//        System.out.println(a.name);
//        System.out.println(b.name);
//    }
//}
//
//
//
//Step 1: What is static here (exactly)?
//
//There are two different statics:
//
//static class Test
//
//static String name
//
//They affect different layers.
//
//Step 2: Meaning of static class Test
//static class Test { ... }
//
//
//Means:
//
//Test does not depend on an InnerClass object.
//
//That’s it.
//Nothing about memory sharing of fields.
//
//So you can do:
//
//        new Test("Anil");
//
//
//from static main.
//
//        Step 3: Meaning of static String name
//static String name;
//
//
//Means:
//
//There is ONE name variable for the entire Test class, shared by all Test objects.
//
//Not per object. Per class.
//
//Step 4: Constructor execution (machine-eye view)
//First object
//Test a = new Test("Anil");
//
//
//Constructor runs:
//
//        this.name = name;
//
//
//Translated correctly:
//
//Test.name = "Anil";
//
//
//Now memory:
//
//Test.name → "Anil"
//
//Second object
//Test b = new Test("Achu");
//
//
//Constructor runs again:
//
//Test.name = "Achu";
//
//
//Memory now:
//
//Test.name → "Achu"
//
//
//The previous value is overwritten.
//
//        Step 5: Printing
//System.out.println(a.name);
//System.out.println(b.name);
//
//
//Both read from:
//
//Test.name
//
//
//So both print:
//
//Achu
//        Achu