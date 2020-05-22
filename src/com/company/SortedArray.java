package com.company;


import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Predicate;

public class SortedArray<T> {

    private final T[] mainArray;
    private int numberOfElements;

    SortedArray(Class<T> template, int numberOfElements) throws InstantiationException, IllegalAccessException {
        this.numberOfElements = numberOfElements;
        mainArray = (T[]) Array.newInstance(template, numberOfElements);
        fillArray(template);
//        print();
    }

    void fillArray(Class<T> template) throws IllegalAccessException, InstantiationException {
        for (int i = 0; i < mainArray.length; i++) {
            mainArray[i] = template.newInstance();
        }
    }

    void print(){
        for (T t : mainArray) {
            System.out.println(t.toString());
        }
    }

    ArrayList<T> getPart(Predicate<T> predicate){
        ArrayList<T> list = new ArrayList<>();
        for(T temp: mainArray){
            if(predicate.test(temp))
                list.add(temp);
        }
        return list;
    }

}
