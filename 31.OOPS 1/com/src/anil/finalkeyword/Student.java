package com.src.anil.finalkeyword;

public class Student {
    int rollno;
    String name;
    final float marks = 90; //initialize always the final.

    Student(int rollno,String name){
        this.rollno = rollno;
        this.name = name;
    }
}
