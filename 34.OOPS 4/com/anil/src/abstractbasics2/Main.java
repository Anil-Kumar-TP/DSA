package com.anil.src.abstractbasics2;

public class Main {
    public static void main(String[] args) {
        Son son = new Son();
        Partner myPartner = son.choosePartner();
        System.out.println(myPartner.name);
    }
}
