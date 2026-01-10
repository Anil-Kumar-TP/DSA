package com.anil.src.inheritancebasics;

public class BoxWeight extends Box{
    double weight;

    BoxWeight(){
        this.weight = -1;
        this.h = 2;
    }

    public BoxWeight(double l, double h, double w, double weight) {
        super(l, h, w);//call the parent class constructor with 3 params.
        this.weight = weight;
    }
}
