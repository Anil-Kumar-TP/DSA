package com.anil.src.multilevelinheritence;

public class BoxWeight extends Box{
    double weight;

    BoxWeight(){
        this.weight = 1;
    }

    BoxWeight(double weight){
        this.weight = weight;
    }

    public BoxWeight(double l, double h, double w, double weight) {
        super(l, h, w);
        this.weight = weight;
    }

    public BoxWeight(double side, double weight) {
        super(side);
        this.weight = weight;
    }

}
