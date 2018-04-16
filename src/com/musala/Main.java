package com.musala;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

interface Player {

    static int count() {
        return 5;
    }

    default void play() {
        System.out.println("default");
    }
}

class DVDPlayer implements Player {

}

public class Main {

    public static void main(String[] args) {

        HashMap<String, Integer> numbers = new HashMap<>();

        numbers.insert("seven", 7);
        numbers.insert("zero", 0);
        numbers.insert("eleven", 11);
        numbers.insert("five", 5);

//        numbers.remove("eleven");
//        numbers.remove("five");
//        numbers.remove("zero");

        System.out.println(numbers.contains("seven"));

        numbers.remove("zero");
        numbers.remove("zero");

        System.out.println(numbers);
    }
}
