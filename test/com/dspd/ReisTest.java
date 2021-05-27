package com.dspd;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class ReisTest {

    @Test
    public void generateSSPT() {
        Locatie locA = new Locatie("A");
        Locatie locB = new Locatie("B");
        Locatie locC = new Locatie("C");

        locA.addLocationConnection(new Treinrit(2, locA, locB));
        locA.addLocationConnection(new Treinrit(10, locA, locC));
        locB.addLocationConnection(new Treinrit(2, locB, locC));

        Reis reisA = new Reis("reisA", locA, locC);
        reisA.generateSSPT();

        Locatie locZ = new Locatie("Z");
        Locatie locY = new Locatie("Y");
        Locatie locU = new Locatie("U");

        locZ.addLocationConnection(new Rit(2, locZ, locY));
        locY.addLocationConnection(new Rit(10, locZ, locU));
        locU.addLocationConnection(new Rit(2, locY, locU));

        Reis reisB = new Reis("reisB", locZ, locU);
        reisB.generateSSPT();

        assertEquals(reisA.getReistype(), "Minuuts");
        assertEquals(reisB.getReistype(), "KM");
        assertNotEquals(reisA.getReistype(), reisB.getReistype());

    }

    @Test
    public void getLocatieRouteSSP() {
        Locatie locA = new Locatie("A");
        Locatie locB = new Locatie("B");

        locA.addLocationConnection(new Vlucht(2, locA, locB));
        locB.addLocationConnection(new Vlucht(10, locB, locA));

        Reis reisA = new Reis("reisA", locA, locB);
        reisA.generateSSPT();
        reisA.setLocatieRouteSSP();
        List<Locatie> locatieListA = reisA.getLocatieRouteSSP();

        assertEquals(locatieListA.get(0), locA);
    }

    @Test
    public void getStartingPoint() {
        Locatie locA = new Locatie("A");
        Locatie locB = new Locatie("B");

        Reis reisA = new Reis("reisA", locA, locB);
        Reis reisB = new Reis("reisB", locB, locA);

        assertEquals(reisA.getStartingPoint(), locA);
        assertEquals(reisB.getStartingPoint(), locB);
        assertNotEquals(reisA.getStartingPoint(), reisB.getStartingPoint());
    }

    @Test
    public void getEndPoint() {
        Locatie locA = new Locatie("A");
        Locatie locB = new Locatie("B");

        Reis reisA = new Reis("reisA", locA, locB);
        Reis reisB = new Reis("reisB", locB, locA);

        assertEquals(reisA.getEndPoint(), locB);
        assertEquals(reisB.getEndPoint(), locA);
        assertNotEquals(reisA.getEndPoint(), reisB.getEndPoint());
    }

    @Test
    public void compareTo() {
        Locatie locOne = new Locatie("1");
        Locatie locTwo = new Locatie("2");
        Locatie locThree = new Locatie("3");

        locOne.addLocationConnection(new Treinrit(2, locOne, locTwo));
        locOne.addLocationConnection(new Treinrit(10, locOne, locThree));
        locTwo.addLocationConnection(new Treinrit(2, locTwo, locThree));

        Reis reisOne = new Reis("reis1", locOne, locThree);
        reisOne.generateSSPT();

        Locatie locFour = new Locatie("Z");
        Locatie locFive = new Locatie("Y");
        Locatie locSix = new Locatie("U");

        locFour.addLocationConnection(new Rit(4, locFour, locFive));
        locFive.addLocationConnection(new Rit(20, locFour, locSix));
        locSix.addLocationConnection(new Rit(4, locFive, locSix));

        Reis reisTwo = new Reis("reis2", locFour, locSix);
        reisTwo.generateSSPT();

        assertEquals(reisOne.compareTo(reisTwo), 0);
    }

    @Test
    public void setEndPoint() {
        Locatie locA = new Locatie("A");
        Locatie locB = new Locatie("B");
        Locatie locC = new Locatie("C");

        locA.addLocationConnection(new Treinrit(2, locA, locB));
        locA.addLocationConnection(new Treinrit(10, locA, locC));
        locB.addLocationConnection(new Treinrit(2, locB, locC));

        Reis reisA = new Reis("reisA", locA, locC);
        reisA.generateSSPT();

        assertEquals((int) reisA.getEndPoint().getDistance(), 4);

        reisA.setEndPoint(locB);
        assertEquals((int) reisA.getEndPoint().getDistance(), 2);

    }
}