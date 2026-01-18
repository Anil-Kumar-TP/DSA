package com.anil.src.abstractbasics;

public class Son extends Parent{


    public Son(int age) {
        super(age);
    }

    @Override
    void career() {
        System.out.println("Good career");
    }

    @Override
    void partner() {
        System.out.println("Good partner");
    }
}
