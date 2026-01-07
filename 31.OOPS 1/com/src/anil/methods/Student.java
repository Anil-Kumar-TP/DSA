package com.src.anil.methods;

public class Student {
    int rollno;
    String name;
    float marks;

    void greeting(){
        System.out.println("Hello my name is " + name);
    }

    void changeName(String newName){
        this.name = newName;
    }

    Student(){
        this.name = "Anil";
        this.marks = 90;
        this.rollno = 12;
    }
}
