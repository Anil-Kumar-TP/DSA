package com.src.anil.finalkeyword;

public class Main {
    public static void main(String[] args) {
       final Student anil = new Student(13,"Anil"); //here non primitive (Student) is final
        anil.name = "Anil Kumar"; //this is possible even with final
//        anil = new Student(12,"achu"); this is not possible.reassigning.
    }
}
