package com.company;

import java.util.Comparator;

public class Flat {
    private double square;
    private double price;
    private boolean blocked;

    Flat() {
        square = Math.random() * 100;
        price = Math.random() * 100;
        this.blocked = false;
    }

    static Comparator<Flat> getComparator() {
        return (Flat::compareTo);
    }

    void blockFlat(){
        this.blocked = true;
    }

    int compareTo(Flat nextFlat) {
        int comp = Double.compare(square, nextFlat.square);
        if(comp!=0)
            return comp;
        else {
            return Double.compare(price, nextFlat.price);
        }
    }


    public String toString() {

        return "Square: " + square + ", price: " + price;
    }

}
