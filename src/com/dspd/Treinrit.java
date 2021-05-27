package com.dspd;

public class Treinrit extends Stap {

    private final String type = "Minuuts";

    public Treinrit(double weight, Locatie startingLocation, Locatie endLocation) {
        super(weight, startingLocation, endLocation);
    }

    @Override
    public String getWeighttype() {
        return type;
    }
}
