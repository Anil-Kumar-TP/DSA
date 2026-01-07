package com.anil.src.staticblock;

public class StaticBlock {
    static int a = 5;
    static int b;

    static {
        System.out.println("inside static block");
        b = a * 5;
    }

    public static void main(String[] args) {
        StaticBlock obj = new StaticBlock();//this is not even needed.
        System.out.println(StaticBlock.a + " " + StaticBlock.b);

        b = b * 10;

        System.out.println(StaticBlock.a + " " + StaticBlock.b);

    }
}


//JVM starts
//   ↓
//Class loaded
//   ↓
//Static fields initialized
//   ↓
//Static blocks executed
//   ↓
//main() invoked   ← entry point

//main is the entry point of execution, but class initialization happens before execution begins
//static block runs even before main


//JVM starts → wants to call main
//
//To call main, JVM must initialize StaticBlock.