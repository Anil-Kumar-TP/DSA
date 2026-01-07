package com.src.anil.methods;


public class Main {
    public static void main(String[] args) {
        Student anil = new Student();
        anil.greeting();
        System.out.println(anil.marks);
        System.out.println(anil.name);
        System.out.println(anil.rollno);
        anil.changeName("Achu");
        System.out.println(anil.name);
        anil.greeting();
    }
}
