package com.company;

import java.util.Comparator;

public class Flat {
    private final double square;
    private final double price;
    private boolean blocked;
    private boolean bought;

    Flat() {
        square = ((int) (Math.random() * 10000)) / 100.0;
        price = ((int) (Math.random() * 10000)) / 100.0;
        this.blocked = false;
        this.bought = false;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public double getSquare() {
        return square;
    }

    public double getPrice() {
        return price;
    }

    static Comparator<Flat> getComparator() {
        return (Flat::compareTo);
    }

    void blockFlat() {
        this.blocked = true;
    }

    void unblockFlat(){
        this.blocked = false;
    }

    void buyFlat(){
        this.bought = true;
    }



    int compareTo(Flat nextFlat) {
        int comp = Double.compare(price, nextFlat.price);
        if (comp != 0)
            return comp;
        else {
            return Double.compare(square, nextFlat.square);
        }
    }


    public String toString() {
        return "Price: " + price + ", square: " + square + ", blocked: " + blocked + ", bought: " + bought;
    }

}
