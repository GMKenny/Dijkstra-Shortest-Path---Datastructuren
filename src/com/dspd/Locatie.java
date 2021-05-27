package com.dspd;

import com.sun.org.apache.xerces.internal.impl.xpath.XPath;

import java.util.ArrayList;
import java.util.List;

public class Locatie implements Comparable<Locatie>{
    private final String name;
    private final List<Stap> locationConnections = new ArrayList<>();

    private Locatie lastlocation;
    private boolean processed;
    private double distance = Double.MAX_VALUE;

    public Locatie(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void addLocationConnection(Stap stap){
        locationConnections.add(stap);
    }

    public List<Stap> getLocationConnections(){
        return locationConnections;
    }

    public void setLastLocation(Locatie lastlocation){
        this.lastlocation = lastlocation;
    }

    public Locatie getLastLocation(){
        return lastlocation;
    }

    public void setProcessed(boolean processed){
        this.processed = processed;
    }

    public boolean getProcessed(){
        return processed;
    }

    public void setDistance(double distance){
        this.distance = distance;
    }

    public double getDistance(){
        return distance;
    }

    public void resetLocation(){
        this.locationConnections.clear();
        this.distance = Double.MAX_VALUE;
        this.lastlocation = null;
        this.processed = false;
    }

    @Override
    public int compareTo(Locatie loc) {
        if (this.getName().equals(loc.getName())){
            return 1;
        }
        return 0;
    }
}
