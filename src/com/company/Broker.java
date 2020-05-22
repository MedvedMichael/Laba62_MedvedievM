package com.company;

import java.util.ArrayList;

public class Broker {
    BrokerService service;
    ArrayList<Flat> soldFlats;

    Broker(BrokerService service) {
        this.service = service;
        soldFlats = new ArrayList<>();
    }

    ArrayList<Flat> fetchAvailableFlats(double[] priceLimits, double[] squareLimits) {
        return service.getFlatsByCriteria(priceLimits, squareLimits);
    }

    public String toString() {
        String output = "Broker sold " + soldFlats.size() + " flats" + ((soldFlats.size() != 0) ? ":\n" : "");
        for (Flat flat : soldFlats)
            output += flat.toString() + "\n";
        return output;
    }

}
