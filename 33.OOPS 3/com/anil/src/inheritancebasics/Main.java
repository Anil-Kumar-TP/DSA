package com.anil.src.inheritancebasics;

public class Main {
    public static void main(String[] args) {
        Box box1 = new Box();
        System.out.println(box1.l + " " + box1.h + " " + box1.w);

        Box box2 = new Box(box1);
        System.out.println(box2.l + " " + box2.h + " " + box2.w);

        BoxWeight box3 = new BoxWeight();//without super() we cant pass the parent var inside the constructor. we can use it like as seen here where h is from the parent.
        System.out.println(box3.h + " " + box3.weight);

        //now it is possible.
        BoxWeight box4 = new BoxWeight(12,13,14,20);
        System.out.println(box4.h);

        Box box5 = new BoxWeight(20,18,19,32);
        System.out.println(box5.l);
    }
}
