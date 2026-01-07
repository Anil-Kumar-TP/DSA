package com.anil.src.staticmethod;

public class Main {
    public static void main(String[] args) {
        fun();
    }

     static void fun(){
        greeting();
    }

       static void greeting() {
         System.out.println("Hello");
    }
}