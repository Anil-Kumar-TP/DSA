package com.anil.src.multilevelinheritence;

public class Main {
    public static void main(String[] args) {
        BoxPrice box = new BoxPrice(12,10,11,9,30);
        System.out.println(box.price);

        Box box1 = new BoxPrice(10,19,21,23,99);
        System.out.println(box1.l);
    }
}
