package com.dspd;

public class Rit extends Stap{

    private final String type = "KM";

    public Rit(double weight, Locatie startingLocation, Locatie endLocation) {
        super(weight, startingLocation, endLocation);
    }

    @Override
    public String getWeighttype() {
        return type;
    }
}
