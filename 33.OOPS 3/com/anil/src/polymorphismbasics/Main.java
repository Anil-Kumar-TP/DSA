package com.anil.src.polymorphismbasics;

public class Main {
    public static void main(String[] args) {
        Shapes shapes = new Shapes();
        Square square = new Square();
        Circle circle = new Circle();

        shapes.area();
        square.area();
        circle.area();

        Shapes square1 = new Square();
        square1.area();
    }
}
