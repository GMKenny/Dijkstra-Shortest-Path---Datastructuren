package com.dspd;

public class Vlucht extends Stap{

    public Vlucht(String name) {
        super(name);
    }

    @Override
    public void call() {
        System.out.println("test");
    }
}
