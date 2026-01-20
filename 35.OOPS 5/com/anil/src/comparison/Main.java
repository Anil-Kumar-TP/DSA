package com.anil.src.comparison;

public class Main {
    public static void main(String[] args) {
        Student anil = new Student(13,90.2f);
        Student achu = new Student(23,80.2f);

        if (achu.compareTo(anil) < 0){
            System.out.println("Anil has more marks");
        }
    }
}
