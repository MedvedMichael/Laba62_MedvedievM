package com.company;

public class BrokerService {
    SortedArray<Flat> table;
    BrokerService() throws IllegalAccessException, InstantiationException {
        table = new SortedArray<>(Flat.class,Flat.getComparator(),10);

    }
}
