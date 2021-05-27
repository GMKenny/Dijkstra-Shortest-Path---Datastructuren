package com.dspd;

import org.junit.Test;

import static org.junit.Assert.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class LocatieTest {

    @Test
    public void getName() {
        Locatie locA = new Locatie("A");
        Locatie locB = new Locatie("B");
        locA.addLocationConnection(new Rit(15, locA, locB));

        assertEquals(locA.getName(), "A");
        assertEquals(locB.getName(), "B");
    }

    @Test
    public void getDistance() {
        Locatie locatieA = new Locatie("A");
        Locatie locatieB = new Locatie("B");
        Locatie locatieC = new Locatie("C");
        Locatie locatieD = new Locatie("D");
        Locatie locatieE = new Locatie("E");

        locatieA.addLocationConnection(new Treinrit(15, locatieA, locatieD));
        locatieA.addLocationConnection(new Treinrit(8, locatieA, locatieB));
        locatieB.addLocationConnection(new Treinrit(9, locatieB, locatieC));
        locatieC.addLocationConnection((new Treinrit(5, locatieC, locatieD)));
        locatieC.addLocationConnection(new Treinrit(5, locatieC, locatieE));
        locatieD.addLocationConnection(new Treinrit(5, locatieD, locatieE));

        Reis ReisA = new Reis("ReisA", locatieA, locatieB);
        ReisA.generateSSPT();

        assertEquals((int) locatieE.getDistance(), 20);

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

        assertEquals(locOne.compareTo(locTwo), 0);


    }

    @Test
    public void resetLocation() {
        Locatie locA = new Locatie("A");
        Locatie locB = new Locatie("B");
        Locatie locC = new Locatie("C");

        locA.addLocationConnection(new Rit(1, locA, locB));
        locA.addLocationConnection(new Rit(4, locA, locC));
        locB.addLocationConnection(new Rit(1, locB, locC));

        Reis ReisA = new Reis("ReisA", locA, locC);
        ReisA.generateSSPT();

        assertEquals((int) locC.getDistance(), 2);

        locA.resetLocation();
        locB.resetLocation();
        locC.resetLocation();

        locA.addLocationConnection(new Rit(1, locA, locB));
        locA.addLocationConnection(new Rit(4, locA, locC));
        Reis ReisB = new Reis("ReisB", locA, locC);
        ReisB.generateSSPT();

        assertEquals((int) locC.getDistance(), 4);

    }
}