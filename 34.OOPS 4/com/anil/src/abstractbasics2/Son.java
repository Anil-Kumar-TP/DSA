package com.anil.src.abstractbasics2;

public class Son extends Parent{

    @Override
    Partner choosePartner() {
        return new Partner("A partner");
    }
}
