package com.dspd;

public class Main {

    public static void main(String[] args) {

        Locatie locatieNodeAmsterdam = new Locatie("Amsterdam");
        Locatie locatieNodeBussum = new Locatie("Bussum");
        Locatie locatieNodeHilversum = new Locatie("Hilversum");
        Locatie locatieNodeUtrecht = new Locatie("Utrecht");
        Locatie locatieNodeAmersfoort = new Locatie("Amersfoort");

        locatieNodeAmsterdam.addLocationConnection(new Treinrit(15, locatieNodeAmsterdam, locatieNodeUtrecht));
        locatieNodeAmsterdam.addLocationConnection(new Treinrit(8, locatieNodeAmsterdam, locatieNodeBussum));
        locatieNodeBussum.addLocationConnection(new Treinrit(9, locatieNodeBussum, locatieNodeHilversum));
        locatieNodeHilversum.addLocationConnection((new Treinrit(5, locatieNodeHilversum, locatieNodeUtrecht)));
        locatieNodeHilversum.addLocationConnection(new Treinrit(5, locatieNodeHilversum, locatieNodeAmersfoort));
        locatieNodeUtrecht.addLocationConnection(new Treinrit(5, locatieNodeUtrecht, locatieNodeAmersfoort));

        Reis AmsterdamTo = new Reis("Amterdam to", locatieNodeAmsterdam, locatieNodeAmersfoort);
        AmsterdamTo.generateSSPT();
        System.out.println(AmsterdamTo.toString());

        AmsterdamTo.setEndPoint(locatieNodeUtrecht);
        System.out.println(AmsterdamTo.toString());

        locatieNodeAmsterdam.resetLocation();
        locatieNodeBussum.resetLocation();
        locatieNodeHilversum.resetLocation();
        locatieNodeUtrecht.resetLocation();
        locatieNodeAmersfoort.resetLocation();

        locatieNodeAmsterdam.addLocationConnection(new Rit(30, locatieNodeAmsterdam, locatieNodeUtrecht));
        locatieNodeAmsterdam.addLocationConnection(new Rit(10, locatieNodeAmsterdam, locatieNodeBussum));
        locatieNodeAmsterdam.addLocationConnection(new Rit(15, locatieNodeAmsterdam, locatieNodeHilversum));
        locatieNodeBussum.addLocationConnection(new Rit(10, locatieNodeBussum, locatieNodeHilversum));
        locatieNodeBussum.addLocationConnection(new Rit(10, locatieNodeBussum, locatieNodeUtrecht));
        locatieNodeHilversum.addLocationConnection((new Rit(15, locatieNodeHilversum, locatieNodeUtrecht)));
        locatieNodeHilversum.addLocationConnection(new Rit(5, locatieNodeHilversum, locatieNodeAmersfoort));
        locatieNodeUtrecht.addLocationConnection(new Rit(20, locatieNodeUtrecht, locatieNodeAmersfoort));

        Reis AmsterdamToTwo = new Reis("Amterdam to", locatieNodeAmsterdam, locatieNodeAmersfoort);
        AmsterdamToTwo.generateSSPT();
        System.out.println(AmsterdamToTwo.toString());
        AmsterdamToTwo.setEndPoint(locatieNodeUtrecht);
        System.out.println(AmsterdamToTwo.toString());

        // Reset of new kan alle bij
        locatieNodeAmsterdam.resetLocation();
        Locatie locatieNodeBrussels = new Locatie("Brussels");
        Locatie locatieNodeParis = new Locatie("Paris");
        Locatie locatieNodeMadrid = new Locatie("Madrid");
        Locatie locatieNodeBudapest = new Locatie("Budapest");

        // Een vlucht met tussen stoppen is goedkoper dan een directe vlucht
        locatieNodeAmsterdam.addLocationConnection(new Vlucht(120, locatieNodeAmsterdam, locatieNodeBrussels));
        locatieNodeAmsterdam.addLocationConnection(new Vlucht(300, locatieNodeAmsterdam, locatieNodeParis));
        locatieNodeBrussels.addLocationConnection(new Vlucht(120, locatieNodeBrussels, locatieNodeParis));
        locatieNodeParis.addLocationConnection(new Vlucht(120, locatieNodeParis, locatieNodeMadrid));
        locatieNodeParis.addLocationConnection(new Vlucht(300, locatieNodeParis, locatieNodeBudapest));
        locatieNodeMadrid.addLocationConnection(new Vlucht(120, locatieNodeMadrid, locatieNodeBudapest));
        locatieNodeMadrid.addLocationConnection(new Vlucht(700, locatieNodeMadrid, locatieNodeAmsterdam));

        Reis AmsterdamToThree = new Reis("Amterdam to", locatieNodeAmsterdam, locatieNodeBudapest);
        AmsterdamToThree.generateSSPT();
        System.out.println(AmsterdamToThree.toString());


    }
}
