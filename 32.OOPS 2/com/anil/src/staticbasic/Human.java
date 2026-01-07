package com.anil.src.staticbasic;

public class Human {
    int age;
    String name;
    int salary;
    boolean isMarried;
    static int population;


    //population is not passed in constructor as it is not needed to create an object.
    Human(int age,String name,int salary,boolean isMarried){
        this.age = age;
        this.name = name;
        this.salary = salary;
        this.isMarried = isMarried;
        Human.population += 1;
    }
}

