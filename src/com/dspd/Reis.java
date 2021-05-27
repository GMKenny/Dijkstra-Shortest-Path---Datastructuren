package com.dspd;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Reis implements Comparable<Reis>{
    private final String name;
    private final Locatie startingPoint;
    private Locatie endPoint;
    private List<Locatie> locatieRoute = new ArrayList<Locatie>();

    public Reis(String name, Locatie startingPoint, Locatie endPoint) {
        this.name = name;
        this.startingPoint = startingPoint;
        this.endPoint = endPoint;
    }

    public void generateSSPT(){
        startingPoint.setDistance(0);
        PriorityQueue<Locatie> queue = new PriorityQueue<Locatie>();
        queue.add(startingPoint);
        startingPoint.setProcessed(true);

        while(queue.size() != 0){
            Locatie locatie = queue.peek();
            queue.remove(locatie);

            for (Stap stap : locatie.getLocationConnections()){
                Locatie loc = stap.getEndLocation();

                if(loc.getProcessed()){
                    continue;
                }

                double distance = locatie.getDistance() + stap.getWeight();
                if (distance < loc.getDistance()){
                    queue.remove(loc);
                    loc.setDistance(distance);
                    loc.setLastLocation(locatie);
                    queue.add(loc);
                }
            }
            locatie.setProcessed(true);
        }
    }

    public void setLocatieRouteSSP(){
        Locatie loc = getEndPoint();
        while (loc != null) {
            locatieRoute.add(loc);
            loc = loc.getLastLocation();
        }
        Collections.reverse(locatieRoute);
    }

    public List<Locatie> getLocatieRouteSSP(){
        return locatieRoute;
    }

    public void setEndPoint(Locatie endPoint){
        this.endPoint = endPoint;
    }

    public String toString(){
        setLocatieRouteSSP();
        String string = "Trip: " + getName()  + " " + getEndPoint().getName() + "\nThe sortest route to " +
                getEndPoint().getName() + " is from";

        for (Locatie loc : getLocatieRouteSSP()){
            string += " - " + loc.getName();
        }

        string += " and it will be " + getEndPoint().getDistance() + " " +
                getStartingPoint().getLocationConnections().get(0).getWeighttype();
        return string;
    }

    public Locatie getStartingPoint() {
        return startingPoint;
    }

    public Locatie getEndPoint() {
        return endPoint;
    }

    public String getName(){
        return name;
    }

    public String getReistype(){
        return getStartingPoint().getLocationConnections().get(0).getWeighttype();
    }

    @Override
    public int compareTo(Reis reis) {
        if (this.getReistype() == reis.getReistype()){
            return 1;
        }
        return 0;

    }
}
