package com.src.anil.garbagecollector;

public class Student {
    String name;

    Student(String name){
        this.name = name;
    }

    //we cant free the memory that is happening by java but we can tell what happens during those
    //garbage collection.
    @Override
    protected void finalize() throws Throwable {
        System.out.println("Object destroyed");
    }
}
