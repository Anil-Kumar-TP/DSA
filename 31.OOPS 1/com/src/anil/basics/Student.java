package com.src.anil.basics;

public class Student {
    private final int rollno;
    private String name;
    private float marks;

    public Student(int rollno,String name,float marks){
        this.rollno = rollno;
        this.name = name;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getMarks() {
        return marks;
    }

    public void setMarks(float marks) {
        this.marks = marks;
    }

    public int getRollno() {
        return rollno;
    }
}


