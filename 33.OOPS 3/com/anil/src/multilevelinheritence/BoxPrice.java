package com.anil.src.multilevelinheritence;

public class BoxPrice extends BoxWeight{

    double price;

    BoxPrice(){
        this.price = 0;
    }

    BoxPrice(double price){
        this.price = price;
    }

    public BoxPrice(double l, double h, double w, double weight, double price) {
        super(l, h, w, weight);
        this.price = price;
    }
}
