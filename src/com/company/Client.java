package com.company;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Function;

public class Client {
    private final Broker broker;
    private ArrayList<Flat> possibleVariants;
    private Flat boughtFlat;

    Client(Broker broker) {
        this.broker = broker;
    }

    public ArrayList<Flat> getPossibleVariants() {
        return possibleVariants;
    }

    void autoGetAvailableFlats(){
        double[] priceLimits = new double[]{Math.random()*50, Math.random()*50 + 50};
        double[] squareLimits = new double[]{Math.random()*50, Math.random()*50 + 50};
        this.possibleVariants = broker.fetchAvailableFlats(priceLimits, squareLimits);
    }

    void getAvailableFlatsByCriteria() {
        Scanner scanner = new Scanner(System.in);
        Function<String, Double> convert = Double::parseDouble;
        System.out.println("Input range of price: ");
        double[] priceLimits = map(scanner.nextLine().split(" "));

        System.out.println("Input range of square: ");
        double[] squareLimits = map(scanner.nextLine().split(" "));

        this.possibleVariants = broker.fetchAvailableFlats(priceLimits, squareLimits);
    }

    void autoChoose(){
//        System.out.println(possibleVariants);
        if(possibleVariants.size()==0)
            return;
        int choice = (int)(Math.random()*possibleVariants.size()) + 1;
        buyFlat(choice);
    }

    void chooseWhatToBuy() {
        System.out.println("Possible variants: ");
        int i = 1;
        for (Flat flat : possibleVariants)
            System.out.println(i++ + ") " + flat.toString());

        Scanner scanner = new Scanner(System.in);
        System.out.println("\nWhich do you want to buy?");

        int choice = Integer.parseInt(scanner.nextLine());
        buyFlat(choice);

        System.out.println("You bougth this flat: ");
        System.out.println(boughtFlat.toString());
    }

    private void buyFlat(int choice){
        int i=1;
        for (Flat flat : possibleVariants) {
            if (i++ == choice)
                flat.buyFlat();
            else flat.unblockFlat();
        }
        boughtFlat = possibleVariants.get(choice - 1);
        broker.soldFlats.add(possibleVariants.get(choice - 1));
    }

    private double[] map(String[] arr) {
        double[] output = new double[arr.length];
        for (int i = 0; i < arr.length; i++) {
            output[i] = Double.parseDouble(arr[i]);
        }
        return output;
    }

    public String toString(){
        return (boughtFlat!=null)?("Bought: " + boughtFlat.toString()):"No bought!";
    }

}
