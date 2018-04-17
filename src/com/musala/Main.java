package com.musala;

public class Main {

    public static void main(String[] args) {

        Map<String, Integer> numbers = new LinkedHashMap<>();

        numbers.insert("seven", 7);
        numbers.insert("zero", 0);
        numbers.insert("eleven", 11);
        numbers.insert("five", 5);

        System.out.println(numbers.contains("seven"));

//        numbers.remove("zero");
//        numbers.remove("zero");

        System.out.println(numbers);
    }
}
