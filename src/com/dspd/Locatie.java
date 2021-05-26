package com.dspd;

import com.sun.org.apache.xerces.internal.impl.xpath.XPath;

import java.util.ArrayList;
import java.util.List;

public class Locatie {
    private final String name;
    private final List<Stap> locationConnections = new ArrayList<>();


    public Locatie(String name) {
        this.name = name;
    }

    


}
