package MemoryManagement.MutableObjects;

import java.util.*;

public class Main {
    public static void changeList(List<String> list) {
        list.add("kumar"); // modifies the actual object
    }

    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("anil");

        changeList(names);
        System.out.println(names); // [anil, kumar]
    }
}


//    names holds a reference to the list object.
//
//        Method gets a copy of the reference, which still points to the same object.
//
//        Mutating the object through that reference changes the original list.
//
//        ⚠️ But note: If you reassign the reference inside the method:
//        list = new ArrayList<>();
//        list.add("john");
//
//        This only affects the local copy of the reference, not the caller’s reference.



//    If you reassign the parameter inside the method, it only changes the local copy of the reference. Caller does not see it.
//    void reassign(List<String> list) {
//        list = new ArrayList<>();   // new reference
//        list.add("kumar");
//    }
//
//    public static void main(String[] args) {
//        List<String> names = new ArrayList<>();
//        names.add("anil");
//
//        reassign(names);
//        System.out.println(names); // [anil] ❌ original unchanged
//    }



//✅ To make the caller “see” the new object, you must return the new reference and assign it back in the caller:
//
//        List<String> reassign(List<String> list) {
//        list = new ArrayList<>();  // new object
//        list.add("kumar");
//        return list;               // return new reference
//        }
//
//public static void main(String[] args) {
//        List<String> names = new ArrayList<>();
//        names.add("anil");
//
//        names = reassign(names); // overwrite old reference
//        System.out.println(names); // [kumar] ✅
//        }



//import java.util.*;
//
//public class Main {
//    static List<String> addName(List<String> list) {
//        // Create a new list that includes old contents
//        List<String> newList = new ArrayList<>(list); // copy old elements
//        newList.add("kumar"); // add new element
//        return newList;       // return new reference
//    }
//
//    public static void main(String[] args) {
//        List<String> names = new ArrayList<>();
//        names.add("anil");
//
//        names = addName(names);
//        System.out.println(names); // [anil, kumar] ✅ both preserved
//    }
//}
//new ArrayList<>(list) copied "anil".
//
//        We added "kumar".
//
//        We returned a new reference (pointing to [anil, kumar]).
//
//        Caller’s names now points to this new combined object.



