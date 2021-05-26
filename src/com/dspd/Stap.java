package com.dspd;

abstract class Stap {
    private final Locatie startingLocation;
    private final Locatie endLocation;
    private final double weight;

    public Stap(double weight, Locatie startingLocation, Locatie endLocation) {
        this.weight = weight;
        this.startingLocation = startingLocation;
        this.endLocation = endLocation;
    }

    public double getWeight() {
        return weight;
    }
    public Locatie getStartingLocation(){
        return startingLocation;
    }

    public Locatie getEndLocation(){
        return endLocation;
    }

    public abstract String getWeighttype ();

}
