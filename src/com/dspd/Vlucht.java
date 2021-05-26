package com.dspd;

public class Vlucht extends Stap{

    private final String type = "Euro";

    public Vlucht(double weight, Locatie startingLocation, Locatie endLocation) {
        super(weight, startingLocation, endLocation);
    }

    @Override
    public String getWeighttype() {
        return type;
    }
}
