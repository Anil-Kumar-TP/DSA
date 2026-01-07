package com.src.anil.constuctorcallingother;

public class Student {
    int rollno;
    String name;
    float marks;

    Student(){
        this(13,"Achu",90);
    }

    Student(int rollno,String name,float marks){
        this.rollno = rollno;
        this.name = name;
        this.marks = marks;
    }
}
