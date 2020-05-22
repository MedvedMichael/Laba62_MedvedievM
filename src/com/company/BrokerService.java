package com.company;

import java.util.ArrayList;
import java.util.function.Predicate;

public class BrokerService {
    SortedArray<Flat> table;
    BrokerService() throws IllegalAccessException, InstantiationException {
        table = new SortedArray<>(Flat.class,50);
    }

    void printTable(){
        table.print();
    }

    ArrayList<Flat> getFlatsByCriteria(double [] priceLimits, double [] squareLimits){
        Predicate<Flat> predicate = (flat -> !flat.isBlocked() && flat.getPrice() > priceLimits[0] && flat.getPrice() < priceLimits[1] && flat.getSquare() > squareLimits[0] && flat.getSquare() < squareLimits[1]);
        ArrayList<Flat> data = table.getPart(predicate);
        for(Flat flat:data)
            flat.blockFlat();
        return data;
    }

}
