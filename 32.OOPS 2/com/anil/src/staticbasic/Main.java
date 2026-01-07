package com.anil.src.staticbasic;

public class Main {
    public static void main(String[] args) {
        Human anil = new Human(24,"Anil",25000,true);
        Human achu = new Human(22,"Achu",20000,false);
        System.out.println(anil.name);

        System.out.println(Human.population);
    }
}
