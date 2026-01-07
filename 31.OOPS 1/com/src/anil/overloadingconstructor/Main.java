package com.src.anil.overloadingconstructor;

public class Main {
    public static void main(String[] args) {
        Student anil = new Student(13,"anil",39);
        Student achu = new Student(anil);
        System.out.println(achu.name);
    }
}
