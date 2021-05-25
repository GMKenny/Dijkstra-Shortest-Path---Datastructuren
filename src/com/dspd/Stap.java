package com.dspd;

abstract class Stap {
    private String name;

    public Stap(String name) {
        this.name = name;
    }

    public abstract void call ();

}
