package com.anil.src.interfacebasics;

public class Main {
    public static void main(String[] args) {
        Car car = new Car();
        car.acc();
        car.start();
        car.stop();

        Media carMedia = new Car();
        carMedia.start();
        carMedia.stop();


        NiceCar car1 = new NiceCar();
        car1.start();
        car1.startMusic();
        car1.upgradeEngine();
        car1.start();
    }
}
