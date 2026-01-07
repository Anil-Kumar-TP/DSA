package com.src.anil.basics;

public class Main {
    public static void main(String[] args) {
        Student anil = new Student(13,"anil",87);
        anil.setMarks(90);
        anil.setName("Anil");
        System.out.println(anil.getName());
        System.out.println(anil.getMarks());
        System.out.println(anil.getRollno());
    }
}

