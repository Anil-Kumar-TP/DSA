package com.anil.src.abstractbasics;

public class Daughter extends Parent{

    public Daughter(int age) {
        super(age);
    }

    @Override
    void career() {
        System.out.println("Ok career");
    }

    @Override
    void partner() {
        System.out.println("Ok partner");
    }
}
