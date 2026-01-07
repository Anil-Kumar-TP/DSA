package com.src.anil.overloadingconstructor;

public class Student {
    int rollno;
    String name;
    float marks;

    Student(int rollno,String name,float marks){
        this.rollno = rollno;
        this.name = name;
        this.marks = marks;
    }

    Student(Student other) {
        this.rollno = other.rollno;
        this.name = other.name;
        this.marks = other.marks;
    }
}
