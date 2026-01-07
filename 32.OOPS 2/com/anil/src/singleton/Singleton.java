package com.anil.src.singleton;

public class Singleton {

    private Singleton(){

    }

    private static Singleton instance;//instance is a ref var pointing to the obj of Singleton.
//    There is ONE reference variable for the entire class, shared by everyone.
//
//    Not one per object.
//    One per class.

    public static Singleton getInstance(){//this was made static bcs to call a non static method we need an obj but cant create one bcs it is private constructor.
        if (instance == null){
            instance = new Singleton();
        }

        return instance;
    }
}
