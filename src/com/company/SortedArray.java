package com.company;


import java.lang.reflect.Array;
import java.util.*;

public class SortedArray<T> {

    private T[] mainArray;
    private int numberOfElements;
    private Comparator<T> comparator;

    SortedArray(Class<T> template, Comparator<T> comparator, int numberOfElements) throws InstantiationException, IllegalAccessException {
        this.numberOfElements = numberOfElements;
        this.comparator = comparator;
        mainArray = (T[]) Array.newInstance(template, numberOfElements);
        fillArray(template);
        sort();
        print();
    }

    void fillArray(Class<T> template) throws IllegalAccessException, InstantiationException {
        for (int i = 0; i < mainArray.length; i++) {
            mainArray[i] = template.newInstance();
            System.out.println(mainArray[i].toString());
        }
        System.out.println();
    }

    void sort() {
        ArrayList<T> list = new ArrayList<>(Arrays.asList(mainArray));
        list.sort(comparator);
        mainArray = (T[])list.toArray();
    }

    void print(){
        for (int i = 0; i < mainArray.length; i++) {
            System.out.println(mainArray[i].toString());
        }
    }

}
